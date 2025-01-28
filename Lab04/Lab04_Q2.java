import java.util.Scanner;
public class Lab04_Q2 {
    public static void main(String[] args) {
        String review;
        int length;
        String output;
        double total = 0;
        double average;

        System.out.print("Enter chart data: ");
        Scanner input = new Scanner(System.in);

        if( input.hasNextInt()){
                review = input.next();
                input.close();
                length = review.length();
                //CHART
                for(int i=1; i <= length; i++){
                    System.out.printf("%10s %d", "review",i);
                }
                System.out.print("\n");

                for( int line = 9; line >= 1; line--){
                    for(int n = 0; n < length; n++){
                        int num = Character.getNumericValue(review.charAt(n));
                        if(num < line){
                            output = "";
                        }
                        else{
                            output = "***";
                        }
                        System.out.printf("%12s",output);
                    }
                    System.out.print("\n");
                }
                //AVERAGE
                for( int j = 0; j < length; j++){
                    total += Character.getNumericValue(review.charAt(j));
                }
                average = total/length;
                System.out.printf("Average Review : %.1f ", average);
        }  
        else{
            System.out.println("Invalid chart data!");
        }         
    }
}
