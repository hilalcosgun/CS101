import java.util.Random;
import java.util.Scanner;

public class Lab03_Q1Revision {
    public static void main(String[] args) {
        String word;
        String choice;
        int count;
        int num;
        int index;
        int length;
        int repeat;
        
       

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("1) Encode Message\n2) Decode Message\n3)Encode2 Message\n4)Decode2 Message\n5)Quit");
        System.out.print("Enter choice: ");
        choice = input.nextLine();

        while(!choice.equals("5")){  
            while ( choice.equals("2")){ // user cannot decode until choose 1
                System.out.println("No message to decode....");
                System.out.println("1) Encode Message\n2) Decode Message\n3)Encode2 Message\n4)Decode2 Message\n5)Quit");                System.out.print("Enter choice: ");
                choice = input.nextLine(); 
            }
            while (choice.equals("4")){
                System.out.println("No message to decode....");
                System.out.println("1) Encode Message\n2) Decode Message\n3)Encode2 Message\n4)Decode2 Message\n5)Quit");                System.out.print("Enter choice: ");
                choice = input.nextLine(); 
            }
            
            if ( choice.equals("1")){
                
                System.out.print("Enter word to encode: ");
                word = input.nextLine();
                length = word.length();
               
                    if( length < 2 ){
                        System.out.println("Invalid length word - try again");
                        System.out.println("1) Encode Message\n2) Decode Message\n3)Encode2 Message\n4)Decode2 Message\n5)Quit");                        System.out.print("Enter choice: ");
                        choice = input.nextLine();
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

                        System.out.println("1) Encode Message\n2) Decode Message\n3)Encode2 Message\n4)Decode2 Message\n5)Quit");                        System.out.print("Enter choice: ");
                        choice = input.nextLine();

                        word = word.substring(word.indexOf(" ")+1) + word.substring(0,word.indexOf(" "));
                        while ( choice.equals("2")){ // if user choose to decode again gets same output
                            index=0;
                            System.out.print("The decoded message is: ");
                            while( index < length){
                                if ( Character.isLetter(word.charAt(index))){
                                    System.out.print(word.charAt(index));
                                }
                            index++;
                            }
                            System.out.println("\n1) Encode Message\n2) Decode Message\n3)Encode2 Message\n4)Decode2 Message\n5)Quit");                            System.out.print("Enter choice: ");
                            choice = input.nextLine();
                        }
                    }                    
                }
                if ( choice.equals("3")){
                    
                    System.out.print("Enter word to encode: ");
                    word = input.nextLine();
                    String encoded = "";
                    length = word.length();
                   
                        if( length < 2 ){
                            System.out.println("Invalid length word - try again");
                            System.out.println("1) Encode Message\n2) Decode Message\n3)Encode2 Message\n4)Decode2 Message\n5)Quit");                        System.out.print("Enter choice: ");
                            choice = input.nextLine();
                        }
                        else{                        
                            index=length-1;
                            while( index >=0){
                                if( Character.isLetter(word.charAt(index) ) ){
                                encoded = encoded + word.substring(index,index+1) + "*" ;
                                }
                                if(Character.isWhitespace(word.charAt(index))){
                                   encoded = encoded + " ";
                                }
                                 
                                index--;                            
                            }    
                            encoded = encoded.substring(0, encoded.indexOf(" ")-1 )+ " " + encoded.substring(encoded.indexOf(" ") +1 );
                            System.out.println( "The encoded message is: " + encoded );
                            System.out.println("1) Encode Message\n2) Decode Message\n3)Encode2 Message\n4)Decode2 Message\n5)Quit");                        System.out.print("Enter choice: ");
                            choice = input.nextLine();
                            while (choice.equals("4")){ // if user choose to decode again gets same output
                                System.out.print("The decoded message is: ");
                                index = encoded.length()-1;
                                while( index >= 0){
                                    if ( Character.isLetter(encoded.charAt(index)) || Character.isWhitespace(encoded.charAt(index))){
                                        System.out.print(encoded.charAt(index));
                                    }
                                index--;
                                }
                                System.out.println("\n1) Encode Message\n2) Decode Message\n3)Encode2 Message\n4)Decode2 Message\n5)Quit");                            System.out.print("Enter choice: ");
                                choice = input.nextLine();
                            }
                        }                    
                    }
               
            else{ 
                System.out.println("Invalid choice - try again....");
                System.out.println("1) Encode Message\n2) Decode Message\n3)Encode2 Message\n4)Decode2 Message\n5)Quit");                System.out.print("Enter choice: ");
                choice = input.nextLine();
            }           
        }  
        System.out.println("Thank you, goodbye!");
        input.close();
}
}



   
