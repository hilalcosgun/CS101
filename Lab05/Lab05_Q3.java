import java.util.Scanner;

public class Lab05_Q3 {
    public static double sameBirthday(int size){
        final double DAY = 365;
        double improb = 1;
        double prob;
        for(int i = 0; i < size; i++){
            improb *= (DAY-i)/DAY;
        }
        prob = 1 - improb;
        return prob;
    }
    public static int findMax(int num){
        int max = -1;
        while(num > 0 ){
           int digit = num % 10;
           num /= 10;
           if( digit > max){
            max = digit;
           }
        }
        return max;
    }
    public static void displayChart(String str){
        String output;
        int maxLine = findMax(Integer.valueOf(str));
        for(int i=1; i <= str.length(); i++){
            System.out.printf("%10s %d", "review",i);
        }
        System.out.print("\n");
        for( int line = maxLine; line >= 1; line--){
            for(int n = 0; n < str.length(); n++){
                int num = Character.getNumericValue(str.charAt(n));
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
    }
    public static boolean isValidNumeric(String str){
        boolean valid = true;
        for( int i = 0; i < str.length() & valid == true; i++){
            if( !Character.isDigit(str.charAt(i))){
                valid = false;
            }
        }
        return valid;
    }
    public static int countLetter(String str, int index){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == str.charAt(index)){
                count++;
            }
        }
        return count;
    }
    public static String convertWord(String str){
        String converted = "";
        for(int i = 0; i < str.length(); i++){
            if(Character.isLetter(str.charAt(i))){
                int repeat = countLetter(str, i);
                if( repeat > 1){
                  converted += ")";
                }
                else{
                    converted += "(";
                }
            }
            else{
                converted += "*";
            }
        }
        return converted;
    }

    public static void displayMenu(){
        System.out.println("\n1 - Find Probability of Same Birthday\n2 - Draw Chart\n3 - Convert Word\n4 - QUIT");
    }
    public static int getChoice(){
        displayMenu();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter choice: ");
        int choice = in.nextInt();
        
        return choice;
    }
    public static void main(String[] args) {
        int choice = getChoice();
        Scanner in = new Scanner(System.in);

        while( choice != 4){
            if(choice == 1){
            System.out.print("Enter the group size: ");
            int size = in.nextInt();
            System.out.printf("The probability of two people in a group of %d having the same birthday is %.3f%n",size, sameBirthday(size));
        }
        else if(choice == 2){
            System.out.print("Enter chart data: ");
            String data = in.next();
            if(isValidNumeric(data)){
                displayChart(data);
            }
            else{
                System.out.println("Invalid chart data!");
            }
        }
        else if(choice == 3){
            System.out.print("Enter word to convert: ");
            String word = in.next();
            System.out.println("Original word: " + word);
            System.out.println("Converted word: " + convertWord(word));
        }
        else{
            System.out.println("Invalid choice.");
        }
        choice = getChoice();
    }
    System.out.println("GOODBYE!");
    in.close();
    }  
}
