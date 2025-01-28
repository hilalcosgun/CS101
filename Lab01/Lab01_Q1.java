package Lab01;
 import java.util.Scanner; 
public class Lab01_Q1{
public static void main(String[] args) {
    
 double x;
 double y;
 

 Scanner input= new Scanner(System.in);
 System.out.print("Enter x: ");
  x = input.nextDouble();
  y = (Math.pow(x, 3)+ 3*Math.abs( x ) +9)/ Math.pow(x, 2);

  input.close();

 System.out.println("y= " + Math.round(y));
 System.out.printf( "%.2f is between %d and %d", y, (int)Math.floor(y) , (int)Math.ceil(y));

}









}
