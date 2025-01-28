public class FlashCard {
    private String question;
    private String answer;
    private int difficulty;

    public FlashCard(String question, String answer, int difficulty){
        this.question = question;
        this.answer = answer;
        setDifficulty(difficulty);
    }


    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setDifficulty(int difficulty) {
        if(difficulty < 6 && difficulty > 0){
            this.difficulty = difficulty;
        }
        else{
            this.difficulty = 0;
        }
    }

    public void reverseCard(){
        String keeper = question;
        question = answer;
        answer = keeper;
    }

    public void showFlashCardQuestion(){
        int edge = 5;
        int column = 9;
        int width = question.length() + 2*edge;
        for(int i = 1; i <= column; i++){
            System.out.print("*");
            for(int k = 0; k < width; k++){
                if(i == (column + 1) / 2 && k == edge){
                    System.out.print(question);
                    k = edge + question.length() -1;
                }
                else if(i == 1 || i == column){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
                }
            
            System.out.print("*");
            System.out.println();
        }
    }

    public void showFlashCardQAnswer(){
        int edge = 5;
        int column = 9;
        int width = answer.length() + 2*edge;
        for(int i = 1; i <= column; i++){
            System.out.print("*");
            for(int k = 0; k < width; k++){
                if(i == (column + 1) / 2 && k == edge){
                    System.out.print(answer);
                    k = edge + answer.length() -1;
                }
                else if(i == 1 || i == column){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
                }
            
            System.out.print("*");
            System.out.println();
        }
    }

    

    

    public boolean equals( Object obj){
        if( obj instanceof FlashCard ){
            FlashCard otherCard = (FlashCard) obj;
            if( this.question == otherCard.question && this.answer == otherCard.answer ){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        return question + " " + answer + ":" + difficulty;
    }
    
    
    





public static void main(String[] args) {
     FlashCard card = new FlashCard("endoplazmikretikulum", "elma", 2);
        card.showFlashCardQuestion();
}



}


