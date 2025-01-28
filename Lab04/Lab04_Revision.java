import java.util.Scanner;

public class Lab04_Revision {
    public static void main(String[] args) {
        String word;
        char mostUsed = ' ';
        int length;
        int repeat;
        int max = 0;
        int unicode;
        char letter;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter word to convert: ");
        word = input.next();
        length = word.length();
        boolean lower = true;
          
        for(int i = 0; i < length & lower ; i++ ) {
            lower = Character.isLowerCase(word.charAt(i));
        }
        if( word.equalsIgnoreCase("exit")){

        } 
        else if( !lower) {
            System.out.println("Invalid input! Only enter lowercase letters!");
        }
        else{
            for(int i = 0; i < length ; i++) {
                repeat = 1;
                for(int j=0; j < length; j++){
                    if( i != j & word.charAt(i)== word.charAt(j)){
                        repeat++;        
                    }
                    if(repeat > max){
                        max = repeat;
                        mostUsed = word.charAt(i);
                    }
                }  
            }
            word = word.replace(mostUsed, '(');
            for(int i = 0; i < length ; i++) {
                if(Character.isLetter(word.charAt(i))){
                    unicode = word.codePointAt(i) + length ;
                    if( unicode > 122){
                        unicode = (unicode % 122) + 96;
                    }
                    letter = (char) unicode;
                    word = word.substring(0,i) + letter + word.substring(i+1);
                }
            }
            System.out.println("Length: " + length);
            System.out.println("Converted word: " + word);
        }
    input.close();
    }       
}  

