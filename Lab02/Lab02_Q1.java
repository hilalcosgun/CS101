
import java.util.Scanner;
public class Lab02_Q1{
    public static void main(String[] args) {

        double x;
        double y;
        String text;
        
        System.out.print("Enter a real number: ");
        Scanner input = new Scanner(System.in);
    
        if(!input.hasNextDouble()){
            System.out.println("Invalid input - value must be numeric....");
            text = input.nextLine();
            System.out.println("You entered: " + text);
        }   
        else {  
            x = input.nextDouble();
            input.close();
            if( x > 15 ) {
                y = Math.sqrt( Math.pow(x,5) + 1 );   
            }
            else if( x >= 0 ) {
                y = Math.exp(x) - 15;
            }
            else {
                y = x /(x + 10);
            }
            System.out.println("---------------------------------");
            System.out.printf("f(x) = %.2f ", y); 
        }    
    }
}

                
            
            