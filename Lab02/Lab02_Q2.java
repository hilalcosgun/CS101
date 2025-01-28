import java.util.Scanner;

public class Lab02_Q2 {
    public static void main(String[] args) {
        int largeJar;
        int smallJar;
        int order;

        Scanner input = new Scanner(System.in);
        System.out.print("Input the number of small and large jars available and the order size: ");
        smallJar = input.nextInt();
        largeJar = input.nextInt();
        order = input.nextInt();
        input.close();

        int largeJarCapasity = largeJar * 5 ;
        int smallJarNeed = order - largeJarCapasity; 
        
        if( order < 5){
            System.out.println("Order must be larger than 5 litres");
        }
        else {
            if( smallJarNeed >= 0 ){ // that means large jars are not enough.
                if( smallJarNeed <= smallJar){ // check whether we have enough small jars.
                    System.out.printf("Order of %d litres will contain %d small(1 litre)jars" , order, smallJarNeed);
                }
                else {
                    System.out.println("You do not have enough jars to complete the order");
                }
            }
            else if( smallJarNeed < 0){ // that means large jars enough but we still may need small jars.
                smallJarNeed = order % 5;
                if( smallJarNeed <= smallJar){ //check whether we have enough jars for remainder.
                System.out.printf("Order of %d litres will contain %d small(1 litre)jars" , order, smallJarNeed);
                }
                else {
                    System.out.println("You do not have enough jars to complete the order");
                }
            } 
        }
    }
}
    
