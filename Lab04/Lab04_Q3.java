import java.util.Scanner;

public class Lab04_Q3 {
    public static void main(String[] args) {
        String word;
        String converted = "";
        int length;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter word to convert: ");
        word = input.next();

        while( !word.equalsIgnoreCase("exit")){

            length = word.length();
            converted = word;
            for(int i = 0; i < length ; i++) {
                if( Character.isLetter(word.charAt(i))){
                    for(int j=0; j < length; j++){
                        if( i != j & word.charAt(i)== word.charAt(j)){
                            converted = converted.replace(word.charAt(i), '(');
                        }          
                    }
                    if(Character.isLetter(converted.charAt(i))){
                        converted = converted.replace(word.charAt(i),')');
                    }
                }
                else{
                    converted = converted.replace(word.charAt(i), '*');
                }
            }
            
            System.out.printf("Original word : %-10s Converted word : %s %n", word, converted);
            System.out.print("Enter word to convert: ");
            word = input.next();
        }   
    input.close();   
    }
}

