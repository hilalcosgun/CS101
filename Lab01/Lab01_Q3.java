package Lab01;

import java.util.Scanner;

public class Lab01_Q3 {
    public static void main(String[] args) {
        
        final double CARB_PERCENT=0.5;
        final double FAT_PERCENT=0.3;
        final double PRO_PERCENT=0.2;
        final double CARB_CAL_PER_GR=4;
        final double FAT_CAL_PER_GR=9;
        final double PRO_CAL_PER_GR=4;
        

        final double KG_CAL_DEFİCİT= 7700;
        final double MAINTAIN_CAL= 2000;

        double day;
        double lostKilo;
        double dailyCalDeficit;
        double dailyTotalCal;
        double dailyCarbCal;
        double dailyProCal;
        double dailyFatCal;
        double dailyCarbGram;
        double dailyProGram;
        double dailyFatGram;
        
       
        Scanner input = new Scanner(System.in);
        System.out.print("Enter kilograms to lose: ");
        lostKilo= input.nextInt();
        System.out.printf("Enter days to lose %.1f kilograms: ",lostKilo);
        day= input.nextInt();
        System.out.println("*********************************************************************************************************************");
        input.close();

        dailyCalDeficit= Math.round((lostKilo*KG_CAL_DEFİCİT)/day);
        dailyTotalCal= (MAINTAIN_CAL-dailyCalDeficit);
        dailyCarbCal= dailyTotalCal*CARB_PERCENT;
        dailyProCal= dailyTotalCal*PRO_PERCENT;
        dailyFatCal= dailyTotalCal*FAT_PERCENT;
        dailyCarbGram= dailyCarbCal/CARB_CAL_PER_GR;
        dailyProGram= dailyProCal/PRO_CAL_PER_GR;
        dailyFatGram= dailyFatCal/ FAT_CAL_PER_GR;

        System.out.printf("To lose %.1f kilograms in %d days you will need a daily deficit of %d calories \n", lostKilo, (int) day, (int)dailyCalDeficit);
        System.out.println("*********************************************************************************************************************");
        System.out.printf("RECOMMENDED DAİLY CALORİES TO LOSE %.1f KİLOS IN %d DAYS: %d\n" , lostKilo,(int) day, (int)dailyTotalCal);
        System.out.println("*********************************************************************************************************************");
        System.out.printf("%-20s %20s %20s %25s %20s\n", "MACRO","RECOMMEND PERCENT","CALORİES PER GRAM" ,"RECOMMENDED CALORİES", "GRAMS");
        System.out.printf("%-20s %20s %20d %25d %20.1f\n", "CARBONHYDRATE", "%50",(int)CARB_CAL_PER_GR, (int) Math.round(dailyCarbCal), dailyCarbGram);
        System.out.printf("%-20s %20s %20d %25d %20.1f\n", "FAT", "%30", (int)FAT_CAL_PER_GR, (int) Math.round(dailyFatCal),dailyFatGram);
        System.out.printf("%-20s %20s %20d %25d %20.1f\n", "PROTEİN", "%20",(int)PRO_CAL_PER_GR, (int) Math.round(dailyProCal), dailyProGram);
        System.out.println("**********************************************************************************************************************");
 }
}