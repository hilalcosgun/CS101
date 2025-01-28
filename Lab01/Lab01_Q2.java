package Lab01;
import java.util.Scanner;
public class Lab01_Q2 {
    public static void main(String[] args) {

        String info;
        String hour;
        String past;
        String day;
        String month;
        String dayNumber;
        String year;
        

        System.out.printf("Enter date and time: ");
        Scanner userIn = new Scanner(System.in);
        info= userIn.nextLine();
        int index1 = info.indexOf(":");
        int index2 = info.indexOf("/");
        int index3= info.indexOf("-");
        int index4= info.indexOf("-", index3+1);
        int index5= info.indexOf(",");
       

        hour= info.substring(0, index1);
        past= info.substring(index1+1,index2);
        day= info.substring(index2+1, index3);
        month= info.substring(index3+1, index4);
        dayNumber= info.substring(index4+1,index5);
        year= info.substring(index5+1);
        System.out.printf("%s minutes past %s on %s %s %s (%s)", past, hour, dayNumber, month, year, day);

        userIn.close();

       
    
    


    }
    
}
