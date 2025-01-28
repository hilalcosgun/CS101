import java.util.Scanner;

public class Lab04_Q1 {
    public static void main(String[] args) {
        final double DAY = 365;
        
        double improb;
        double prob;
       
        Scanner input = new Scanner(System.in);

        do{
            System.out.print("Enter the minimum and maximum number of people: ");
            int min = input.nextInt();
            int max = input.nextInt();
            if(!(min < max)){
                System.out.println("Invalid input - minimum must be less than maximum...");
            }
        }while(!(min < max));

        input.close();

        System.out.printf("%-20s %-20s%n","NUMBER OF PEOPLE", "PROBABILITY" );
        for( int size = min; size <= max; size++){
            improb = 1;
            for( int i=0; i < size; i++ ){
                improb *= (DAY - i)/DAY;
            }
            prob = 1 - improb;
            System.out.printf("%-20d %-20.3f %n", size, prob);
        }
    }
}





