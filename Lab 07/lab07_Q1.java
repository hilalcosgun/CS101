import java.util.Scanner;

public class lab07_Q1 {
    public static String[] names = { "Ela","Eren","Alona","Jen","Mark","Mel","Ender"};
    public static int[] arrival = {9,5,8,7,9,7,8};
    public static int[]  departure = {12,7,11,12,10,9,10};

    public static Boolean isHere (int index, int currentTime){
        if(arrival[index] <= currentTime & departure[index] > currentTime)
            return true;  
        return false;  
    }

    public static int [] friendsAttending (int myArr, int myDep ){

        int length = myDep - myArr;
        int[] howManyFriends = new int[length];
        int currentTime = myArr;

        for(int i = 0; i < length; i++){
            int count = 0;
            for (int j = 0; j < arrival.length; j++){
                if( isHere(j, currentTime))
                    count++;
            }
            howManyFriends[i] = count;
            currentTime++;
        }  
        return howManyFriends;
    }

    public static int bestTimeToAttend (int myArr, int myDep, String personToAvoid, int[] howManyFriends){

        int avoidIndex = -1;
        int max = -1;
        int bestTime = -1;
        int currentTime;

        for( int i = 0; i < names.length; i++){
            if( personToAvoid.equals(names[i]))
                avoidIndex = i;
        }
        
        currentTime = myArr;

        for(int i = 0; i < howManyFriends.length; i++){
            if( !isHere(avoidIndex, currentTime) & howManyFriends[i] > max){
                bestTime = currentTime; 
                max = howManyFriends[i];
            }
            currentTime++;
        }
        return bestTime; 
         
    }

    public static int bestTimeToAttend (int myArr, int myDep, int[] howManyFriends){
        int currentTime = myArr;
        int bestTime = myArr;
        int max = 0;

        for (int i = 1; i < howManyFriends.length; i++ ){
            currentTime++;
            if(howManyFriends[i] > howManyFriends[max]){
                max = i;
                bestTime = currentTime;
            }
        }
        return bestTime;
    }
    
    public static void main(String[] args) {

        //Q1
        int myArr;
        int myDep;
        int bestTime;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter time interval you are available: ");
        myArr = in.nextInt();
        myDep = in.nextInt();
        
        int[] howManyFriends = friendsAttending(myArr, myDep);

        int currentTime = myArr;
        for (int i = 0; i < howManyFriends.length; i++ ){ 
            System.out.printf("At %dpm, %d friends will be at the party%n", currentTime, howManyFriends[i] );
            currentTime++;
        }
        bestTime = bestTimeToAttend(myArr, myDep, howManyFriends);
        System.out.println("Best time to attend is " + bestTime );

        //Q2
        String personToAvoid;
        /*int myArr;
        int myDep;
        int bestTime;

        Scanner in = new Scanner(System.in);*/
         
        System.out.print("Enter friend you wish to avoid:");
        personToAvoid = in.next();

        System.out.print("Enter time interval you are available: ");
        myArr = in.nextInt();
        myDep = in.nextInt();

        //int[] howManyFriends = friendsAttending(myArr, myDep);

        bestTime = bestTimeToAttend(myArr, myDep, personToAvoid, howManyFriends);
        System.out.printf("Best time to attend to avoid %s and to see the most friends is %d", personToAvoid, bestTime);

        in.close();;
    }
    
}
