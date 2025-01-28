import java.util.ArrayList;
import java.util.Random;
public class Lab06{

private static final int CAMPUS_RADIUS = 250;

public static double calculateDistance(String loc1, String loc2){
    double distance;
    int index1 , index2;
    index1 = loc1.indexOf(",");
    index2 = loc2.indexOf(",");

    int x1 = Integer.valueOf(loc1.substring(0,index1));
    int y1 = Integer.valueOf(loc1.substring(index1+1));
    int x2 = Integer.valueOf(loc2.substring(0,index2));
    int y2 = Integer.valueOf(loc2.substring(index2 + 1));

    distance = Math.sqrt( Math.pow(x1 - x2 , 2) + Math.pow( y1 - y2 , 2));
    return distance;
}
public static boolean doesIntersect (String loc1, String loc2){
    double distance;
    distance =  calculateDistance(loc1 , loc2);
    if( distance < 2*50)
        return true;
    return false;
}
public static int countIntersect ( String loc , ArrayList<String> locations ){
    int count = 0;
    for (int i = 0; i < locations.size(); i++){
        if( doesIntersect(loc , locations.get(i))){
            count++;
        }
    }
    return count;
}
public static void displayIntersections(ArrayList<String> names, ArrayList<String> locations, ArrayList<Integer> months){
    String name;
    String intersectsWith;
    String loc;
    int month;
    for (int i = 0; i < names.size(); i++){
        name = names.get(i);
        loc = locations.get(i);
        month = months.get(i);
        System.out.printf("%s at location %s for %d months intersects with : ", name, loc, month);
        if(countIntersect(loc, locations) > 1){
            for (int k = 0; k < names.size(); k++){
                if(name != names.get(k)  &  doesIntersect(loc , locations.get(k))){
                    intersectsWith = names.get(k);
                    System.out.printf("%n   %s, at location %s for %d months", intersectsWith, locations.get(k), months.get(k));
                }
            }
        }
        else{
            System.out.println( "NO CATS");
        }
        System.out.println();
    }
}
public static int findMinMonthsAtLocation ( String loc, ArrayList<String> locations, ArrayList<Integer> months){
    int min = Integer.MAX_VALUE;
    int index = -1;
    for (int i = 0; i < locations.size(); i++){
        if(doesIntersect(loc , locations.get(i)) &  months.get(i) < min){
            min = months.get(i);
            index = i;
        }
    }
    return index;
}
public static String findRandomLocation (){
    int randX;
    int randY;
    Random rand = new Random();
    do{
        randX = rand.nextInt( CAMPUS_RADIUS * 2 );
        randY = rand.nextInt( CAMPUS_RADIUS * 2 );
    }while( Math.sqrt( Math.pow(250 - randX,2) + Math.pow(250 - randY,2)) > CAMPUS_RADIUS);
    return (randX + "," + randY );
}
public static void moveCats (ArrayList<String> locations, ArrayList<Integer>  months){
    String loc;
    int minIndex;
    String newloc;
    for (int i = 0; i < locations.size(); i++){
        loc = locations.get(i);
        while( countIntersect (loc, locations) >= 3){
            minIndex = findMinMonthsAtLocation(loc, locations, months);
            do{
                newloc = findRandomLocation();
            }while (countIntersect( newloc, locations) != 0);
            locations.set(minIndex, newloc);
            months.set(minIndex, 0);
        }
    }
}
    public static void main(String[] args) {
        int num = 15 ;
        ArrayList<String> catNames = CatInfoGenerator.getRandomNameList(num);
        ArrayList<String> catLocs = CatInfoGenerator.getRandomLocationList(num);
        ArrayList<Integer>catMonths = CatInfoGenerator.getRandomMonthList(num);
        System.out.println("Before moving the cats: \n" );
        displayIntersections (catNames, catLocs, catMonths);
        System.out.println();
        System.out.println("After moving the cats: \n" );
        moveCats(catLocs, catMonths);
        displayIntersections(catNames, catLocs, catMonths);
    } 
}
