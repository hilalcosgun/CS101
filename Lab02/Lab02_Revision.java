import java.util.Scanner;
public class Lab02_Revision {
    public static void main(String[] args) {

        String word;
        char first;
        char middle;
        char last;
        char character;
        int length;
        int midIndex;
        int distance1;
        int distance2;
        int distance3;
        Boolean condition;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string: ");
        word = input.nextLine();
        word = word.replaceAll(" ", "");

        System.out.print("Enter only one character: ");
        character = input.next().charAt(0);
        input.close();

        length = word.length();
        midIndex = length/2  ;

        first = word.charAt(0);
        middle = word.charAt(midIndex);
        last = word.charAt(length-1);

        distance1 = Math.abs(character - first);
        distance2 = Math.abs(character - middle);
        distance3 = Math.abs(character - last);

        condition = (distance1 <=1 & distance2 > 1 & distance3 > 1 ) || (distance2 <=1 & distance1 > 1 & distance3 > 1 )
                    || (distance3 <=1 & distance1 > 1 & distance2 > 1 );

        if( length < 3 ){
            System.out.println("Length of string not sufficient");

        }
        else if( !(Character.isLowerCase(first) & Character.isLowerCase(middle) & Character.isLowerCase(last))){
            System.out.println("Characters not lowercase letters...");
        }
        else{
            if( length == 3) {
                System.out.println( "String is super special: " + condition);
            }
            else {
                System.out.printf("first:%c middle:%c last:%c %n" , first, middle, last);
                System.out.println( "String is super special: " + condition);
            }
        }
  
    }
}






