import java.util.ArrayList;

public class ProjectApp {
    public static void main(String[] args) {
        Project pro1 = new Project("ArcTech Business Solution", 3780, 150, 7);
        Project pro2 = new Project("SunMarkets POS Implementation", 1350,200, 6);
        Project pro3 = new Project("HealthTech Hospital", 810, 75, 3);

        System.out.println(pro1);
        System.out.println();
        System.out.println(pro2);
        System.out.println();

        pro1.setRatePerHour(100);
        pro1.setProjectWeeks(5);
        pro1.setProjectType();

        pro2.setRatePerHour(350);
        pro2.setProjectWeeks(9);
        pro2.setProjectType();

        System.out.println(pro1);
        System.out.println();
        System.out.println(pro2);
        System.out.println();

        pro3.deactiviteProject();

        System.out.println(pro3);
    }
}
