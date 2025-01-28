public class Employee {
    public final int  WORKING_DAYS = 261;
    
    private String employeeName;
    private double dailyRate;
    private Department department;
    private Project project;

    public Employee(String employeeName, double dailyRate, Project project, String deptName, String deptCode){
        this.employeeName = employeeName;
        this.dailyRate = dailyRate;
        this.project = project;
        Department dept = new Department(deptName, deptCode);
        this.department = dept;

    }

    public Employee( Employee toCopy){
        this.employeeName = toCopy.employeeName;
        this.dailyRate = toCopy.dailyRate;
        this.project = toCopy.project;
        this.department = toCopy.department;

    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public Department getDepartment() {
        return department;
    }

    public Project getProject() {
        return project;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    
    public double calculateYearlySalary(){
        return WORKING_DAYS * dailyRate;
    }

    public String toString(){
        return "Employee Name: " + employeeName + " Yearly Salary: " + calculateYearlySalary() + "\nDept Name: " 
        + department.toString() + project.toString();
    }
    
    
}
