import java.util.Scanner;

public class Lab05_Q2 {
    static final String KEY = "a@bpdqi!l1mwnuo0s5t+z2A4B8E3G6WM";
    public static char convertChar(char ch){
        boolean isSame = false;
        for ( int i = 0; i < KEY.length() & !isSame; i += 2){
            if( ch == KEY.charAt(i)){
                ch = KEY.charAt(i+1);
                isSame = true;
            }
        }
        return ch;    
    }
    public static String convertString(String str){
        String converted = "";
        
        for (int i = 0; i < str.length(); i++ ){
            converted += convertChar(str.charAt(i));
        }
        return converted;
    }
    public static int countNumbers(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++ ){
            if(Character.isDigit(str.charAt(i))){
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {

        String str;
        String converted;
        int number;

        System.out.print("Enter a phrase for conversion: ");
        Scanner in = new Scanner(System.in);
        str = in.nextLine();
        converted = convertString(str);
        boolean isConverted = false;
        if( str.isEmpty()){
            System.out.println("No phrase entered.");
        }
        else{
            System.out.printf("Text you entered: '%s'%n", str); 
            if(str.equals(converted)){
                System.out.println("No conversion happened.");
            }
            else{
                System.out.printf("After conversion: '%s'%n", converted );
                isConverted = true;
            }
            if(isConverted){
                number = countNumbers(converted);
                if( number == 0){
                    System.out.println("!! Attention !! There is no number in this text");
                }
            } 
        }
        in.close();
    }
}   