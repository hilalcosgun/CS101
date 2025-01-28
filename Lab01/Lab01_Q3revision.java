
package Lab01;

import java.util.Scanner;

public class Lab01_Q3revision {
    public static void main(String[] args) {
        
        final double CARB_PERCENT = 0.5;
        final double FAT_PERCENT = 0.3;
        final double PRO_PERCENT = 0.2;
        final double CARB_CAL_PER_GR = 4;
        final double FAT_CAL_PER_GR = 9;
        final double PRO_CAL_PER_GR = 4;
        final double KG_CAL_DEFICIT = 7700;
    
        double day;
        double lostKilo;
        double dailyCalDeficit;
        double dailyMinCal;
        double dailyMaxCal;
        double maxCalInput;
        double minCalInput;
    
        double dailyMinCarbCal;
        double dailyMinProCal;
        double dailyMinFatCal;
        double dailyMinCarbGram;
        double dailyMinProGram;
        double dailyMinFatGram;
        double dailyMaxCarbCal;
        double dailyMaxProCal;
        double dailyMaxFatCal;
        double dailyMaxCarbGram;
        double dailyMaxProGram;
        double dailyMaxFatGram;
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter kilograms to lose: ");
        lostKilo = input.nextInt();
        System.out.printf("Enter days to lose %.1f kilograms: ",lostKilo);
        day = input.nextInt();
        System.out.println("Enter the range of calories you would like to meet in a day: ");
        System.out.print("min: ");
        minCalInput = Math.round(input.nextInt());
        System.out.print("max: ");
        maxCalInput = input.nextInt();
        System.out.println("***************************************************************************************************************************************************************");
        input.close();

        dailyCalDeficit = Math.round((lostKilo*KG_CAL_DEFICIT)/day);

        dailyMinCal = minCalInput-dailyCalDeficit;
        dailyMaxCal = maxCalInput-dailyCalDeficit;

        dailyMinCarbCal = dailyMinCal*CARB_PERCENT;
        dailyMinFatCal = dailyMinCal*FAT_PERCENT;
        dailyMinProCal = dailyMinCal*PRO_PERCENT;
        dailyMinCarbGram = dailyMinCarbCal/CARB_CAL_PER_GR;
        dailyMinProGram = dailyMinProCal/PRO_CAL_PER_GR;
        dailyMinFatGram = dailyMinFatCal/FAT_CAL_PER_GR;

        dailyMaxCarbCal = dailyMaxCal*CARB_PERCENT;
        dailyMaxFatCal = dailyMaxCal*FAT_PERCENT;
        dailyMaxProCal = dailyMaxCal*PRO_PERCENT;
        dailyMaxCarbGram = dailyMaxCarbCal/CARB_CAL_PER_GR;
        dailyMaxProGram = dailyMaxProCal/PRO_CAL_PER_GR;
        dailyMaxFatGram = dailyMaxFatCal/FAT_CAL_PER_GR;

        System.out.printf("To lose %.1f kilograms in %d days you will need a daily deficit of %d calories \n", lostKilo, (int) day, (int)dailyCalDeficit);
        System.out.println("***************************************************************************************************************************************************************");
        System.out.printf("RECOMMENDED DAİLY CALORİES TO LOSE %.1f KİLOS IN %d DAYS: max: %d min:%d\n" , lostKilo,(int) day, (int)dailyMinCal, (int)dailyMaxCal);
        System.out.println("***************************************************************************************************************************************************************");
        System.out.printf("%-15s %20s %25s  %15s %15s %10s %10s\n", "MACRO","RECOMMEND PERCENT","CALORİES PER GRAM" , "MİN CALORİES", "MAX CALORİES" ,"MİN GRAMS", "MAX GRAMS");
        System.out.printf("%-15s %20s %25d  %15d %15d %10.1f %10.1f\n", "CARBONHYDRATE", "%50",(int)CARB_CAL_PER_GR,  (int)Math.round(dailyMinCarbCal), (int)Math.round(dailyMaxCarbCal), dailyMinCarbGram,dailyMaxCarbGram );
        System.out.printf("%-15s %20s %25d  %15d %15d %10.1f %10.1f\n", "FAT", "%30", (int)FAT_CAL_PER_GR,  (int)Math.round(dailyMinFatCal), (int)Math.round(dailyMaxFatCal), dailyMinFatGram, dailyMaxFatGram);
        System.out.printf("%-15s %20s %25d  %15d %15d %10.1f %10.1f\n", "PROTEİN", "%20",(int)PRO_CAL_PER_GR, (int)Math.round(dailyMinProCal), (int)Math.round(dailyMaxProCal), dailyMinProGram, dailyMaxProGram); 
        System.out.println("***************************************************************************************************************************************************************");
 }
}