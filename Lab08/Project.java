import java.time.LocalDate;

public class Project {

    public static final double TAX = 0.13;
    public static final int OVERHEAD = 50000;
    public static final int EMP_HOURS_WEEK = 45;

    private static int projectCounter = 5000;

    private String projectId;
    private String projectName;
    private char projectType;
    private int personHours;
    private double ratePerHour;
    private int projectWeeks;
    
    public Project( String projectName, int personHours, double ratePerHour, int projectWeeks){
        projectCounter++;
        this.projectName = projectName;
        setProjectId();
        setPersonHours(personHours);
        setRatePerHour(ratePerHour);
        setProjectWeeks(projectWeeks);
        setProjectType();
    }

    // get methods
    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public char getProjectType() {
        return projectType;
    }

    public int getPersonHours() {
        return personHours;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public int getProjectWeeks() {
        return projectWeeks;
    }

    private int getYear(){
		return LocalDate.now().getYear();
	}

    // set methods
    private void setProjectId() {
        projectId = getYear() + "-" + projectCounter; 
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectType() {
        double projectCost = calculateProjectCost();
        if( projectCost > 1000000){
            projectType = 'm';
        }
        else if( projectCost > 500000 ){
            projectType = 'l';
        }
        else if( projectCost > 0 ){
            projectType = 's';
        }
        else if( projectCost == 0 ){
            projectType = 'i';
        }
    }

    public void setPersonHours(int personHours) {
        if( personHours > 0) {
            this.personHours = personHours;
        }
        else{
            this.personHours = 0;
        }
    }

    public void setRatePerHour(double ratePerHour) {
        if( ratePerHour > 0) {
            this.ratePerHour = ratePerHour;
        }
        else{
            this.ratePerHour = 0;
        }
    }

    public void setProjectWeeks(int projectWeeks) {
        if( projectWeeks > 0) {
            this.projectWeeks = projectWeeks;
        }
        else{
            this.projectWeeks = 0;
        }
    }

    // service methods

    public void deactiviteProject() {
        projectType = 'i';
        personHours = 0;
        ratePerHour = 0;
    }

    public void activiteProject(int personHours, double ratePerHour) {
        this.personHours = personHours;
        this.ratePerHour = ratePerHour;
        setProjectType();
    }

    public int calculatePersonResources() {
        int numberOfEmployee = (personHours / projectWeeks) / EMP_HOURS_WEEK;
        return numberOfEmployee;
    }

    public double calculateProjectCost() {
        double humanCost = personHours * ratePerHour;
        double projectCost = humanCost;
        if( humanCost >= 2000){
            double overhead = OVERHEAD * (1+TAX);
            projectCost += overhead; 
        }
        return projectCost;
    }

    public String toString() {
        if( projectType == 'i'){
            return "-------INACTIVE PROJECT------" + "\nProject Name: " + projectName + "\nProject ID: " + projectId;

        }
        else{
            return "Project Name: " + projectName  + "\nProject ID: " + projectId + "\nProject Type: " 
            + projectType + "\nTeam Size: " + calculatePersonResources() + "\nEstimated Project Cost: " + calculateProjectCost();
        }
        
    }
}