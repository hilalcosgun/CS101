import java.util.Scanner;
import java.util.Random;

public class Lab03_Q1 {
    public static void main(String[] args) {
        String word;
        int choice;
        int count;
        int num;
        int index;
        int length;
        int repeat;
       

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("1) Encode Message\n2) Decode Message\n3) Quit");
        System.out.print("Enter choice: ");
        choice = input.nextInt();

        
        

        while(choice != 3){  
            while ( choice ==2){ // user cannot decode until choose 1
                System.out.println("No message to decode....");
                System.out.println("1) Encode Message\n2) Decode Message\n3) Quit");
                System.out.print("Enter choice: ");
                choice = input.nextInt(); 
            }
            if ( choice == 1){
                
                System.out.print("Enter word to encode: ");
                word = input.next();
                length = word.length();
               
                    if( length < 2 ){
                        System.out.println("Invalid length word - try again");
                        System.out.println("1) Encode Message\n2) Decode Message\n3) Quit");
                        System.out.print("Enter choice: ");
                        choice = input.nextInt();
                    }
                    else{
                        repeat = word.length();
                        count = 0;
                        while(count < repeat){
                            index = random.nextInt(length);
                            num = random.nextInt(10);
                            word = word.substring(0, index) + num + word.substring(index);
                            count++;
                            length++;
                        }
                        index = random.nextInt(length);
                        word = word.substring(index) + " " + word.substring(0, index);
                        System.out.println("Encoded message: " + word);

                        System.out.println("1) Encode Message\n2) Decode Message\n3) Quit");
                        System.out.print("Enter choice: ");
                        choice = input.nextInt();

                        word = word.substring(word.indexOf(" ")+1) + word.substring(0,word.indexOf(" "));
                        while ( choice == 2){ // if user choose to decode again gets same output
                            index=0;
                            System.out.print("The decoded message is: ");
                            while( index < length){
                                if ( Character.isLetter(word.charAt(index))){
                                    System.out.print(word.charAt(index));
                                }
                                index++;
                            }
                            System.out.println("\n1) Encode Message\n2) Decode Message\n3) Quit");
                            System.out.print("Enter choice: ");
                            choice = input.nextInt();
                        }
                    }                    
                }
            else{ 
                System.out.println("Invalid choice - try again....");
                System.out.println("\n1) Encode Message\n2) Decode Message\n3) Quit");
                System.out.print("Enter choice: ");
                choice = input.nextInt();
            }           
        }  
        System.out.println("Thank you, goodbye!");
        input.close();
    }
}

