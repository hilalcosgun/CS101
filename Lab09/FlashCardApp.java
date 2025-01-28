
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FlashCardApp {
    
    public static ArrayList<FlashCard> readCards( String filename ){

        String line;
        String[] data;
        
        //creates an empty list to store FlashCards
        ArrayList<FlashCard> cardList = new ArrayList<FlashCard>();

        //create a File object representing file to read
        File inFile = new File( filename );

        //try the following
        try {
            //create Scanner that reads from file with given name
            Scanner file = new Scanner( inFile );

            //while file contains more data
            while( file.hasNext() ) {
                //read the next line from the file
                String cardInfo = file.nextLine();

                //split the line into tokens (hint: String split() method )
                String[] card = cardInfo.split("\t",3);
                
                //create a FlashCard object using the line tokens - don't forget convert difficulty to int
                int difficulty = Integer.valueOf(card[2]);
                FlashCard flashcard = new FlashCard(card[0], card[1], difficulty);
                
                //add the card to the list
                cardList.add(flashcard);
            }
            //close the file
            file.close();

        }catch( FileNotFoundException f ){
            System.out.println("file cannot be opened");
        }
        //return the ArrayList containing FlashCards from the file
        return cardList;
    }
    public ArrayList<String> bubleSort(ArrayList<String> cardList){
        boolean sorted = false;
        for(int i = 0; i < cardList.size() - 1 && !sorted; i++){
            sorted = false;
            for(int k = 0; k < cardList.size() - 1 - i; k++){
                sorted = true;
                if(cardList.get(k).compareTo(cardList.get(k+1))  > 0 ){
                    String keeper = cardList.get(k);
                    cardList.set(k, cardList.get(k+1));
                    cardList.set(k+1, keeper);
                }
            }
        }
        return cardList;
    }
    public static ArrayList<FlashCard> randomList(ArrayList<FlashCard> cardList, int num){
        ArrayList<FlashCard> randomList = new ArrayList<FlashCard>();
        Random rand = new Random();
        for(int i = 0; i < num; i++){
            int random = rand.nextInt(982)+1;
            randomList.add(i, cardList.get(random));
        }
        return randomList;

    }
    public static void searchByQuestion(ArrayList<FlashCard> cardList){
        Scanner scan = new Scanner(System.in);
        String searched = scan.next();
        while(!searched.equals("no")){
            boolean doesExist = false;
            for(int i = 0; i < cardList.size() && !doesExist; i++){
                if(cardList.get(i).getQuestion().equals(searched)){
                    cardList.get(i).showFlashCardQAnswer();
                    doesExist = true;
                }
                else if(cardList.get(i).getAnswer().equals(searched)){
                    cardList.get(i).showFlashCardQuestion();
                    doesExist = true;
                }
            }
            if(!doesExist){
                System.out.println(searched +"is not found");
            }
            System.out.println("else?");
            searched = scan.next();
        }

    }
    
    public static void main(String[] args) {
        ArrayList<FlashCard> cardList = readCards("turkish_english_words.txt");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        ArrayList<FlashCard> randomList = randomList(cardList,num );

        for(int i = 0; i < randomList.size(); i++){
            randomList.get(i).showFlashCardQuestion();
            String answer = scan.next();
            if(answer.equals(randomList.get(i).getAnswer()))
                System.out.println("true");
            else{
                System.out.println("false");
            }    
        }
        searchByQuestion(cardList);
        
    }
}

