import java.util.Scanner;

public class Lab05_Q1 {

    public static int persistence(int num){

        int multiple;
        int digit;
        int count = 0;
        
        while ( num >= 10){
            multiple = 1;
            while( num > 0 ){
                digit = num % 10;
                multiple *= digit;
                num /= 10;
            }
            num = multiple;
            count ++;
        }
        return count;
    }
    public static void main(String[] args) {

        int num = -1;
        Scanner in = new Scanner(System.in);

        do{
            System.out.print("Enter a positive integer:");
            if( in.hasNextInt()){
                num = in.nextInt();
            }
            else{
                in.next();
            }  
        } while( num <= 0 );

        System.out.println("multiplicative persistence of " + num + " is " + persistence(num));
        in.close();
    }
}