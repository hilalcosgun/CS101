import java.util.Arrays;
import java.util.Scanner;

public class lab07Revision {
    public static String[] names = { "Ela","Eren","Alona","Jen","Mark","Mel","Ender"};
    public static int[] arrival = {9,5,8,7,9,7,8};
    public static int[] departure = {12,7,11,12,10,9,10};

    public static Boolean isHere (int index, int currentTime){
        if(arrival[index] <= currentTime & departure[index] > currentTime)
            return true;  
        return false;  
    }

    public static int[] findBestTime(){
        int bestTime = -1;
        int max = -1;
        for(int currentTime = 1; currentTime < 12; currentTime++){
            int count = 0;
            for(int i = 0; i < names.length; i++){
                if(isHere(i, currentTime)){
                    count++;
                }
            }
            if( count > max){
                max = count;
                bestTime = currentTime;
            }
        }
        int [] best = {max, bestTime};
        return best;
    }

    public static int[] findSecondBest(int bestTime){
        int secondTime = -1;
        //int currentTime = myArr;
        int max = -1;
        for(int currentTime = 1; currentTime < 12; currentTime++){
            int count = 0;
            for(int i = 0; i < names.length; i++){
                if(isHere(i, currentTime) & !isHere(i, bestTime)){
                    count++;
                }
            }
            if( count > max || (count == max & Math.abs(bestTime-currentTime) < Math.abs(bestTime-secondTime))){
                max = count;
                secondTime = currentTime;
            }
        }
        int[] secondBest = {max , secondTime};
        return secondBest;
    }

    public static String[] friendsInTime(int currentTime){
        String [] friendsInTime = new String[10];
        int i = 0;
        int k = 0;
        while(i < names.length){
            if(isHere(i, currentTime)){
                friendsInTime[k] = names[i];
                k++;
            }
            i++;
        }
        return friendsInTime;
    }
    public static void bestInterval(){
        int bestTime = findBestTime()[1];
        int secTime = findSecondBest(bestTime)[1];
        int bestCount = findBestTime()[0];
        int secCount = findSecondBest(bestTime)[0];
        System.out.printf("The shortest interval is %d to %d to meet %d friends%n", secTime, bestTime+1, bestCount + secCount);
        System.out.println("At " + secTime+ "pm, you will meet ");
        for( String i : friendsInTime(secTime)){
            if( i != null)
                System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("At " + bestTime+ "pm, you will meet ");
        for( String i : friendsInTime(bestTime)){
            if( i != null)
                System.out.print(i + " ");
        }
        System.out.println();
       
            
    }
    public static void main(String[] args) {
        bestInterval();
    }

}
