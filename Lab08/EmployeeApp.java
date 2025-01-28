import java.util.ArrayList;

public class EmployeeApp {

    public static void main(String[] args) {
        
        Project pro1 = new Project("ArcTech Business Solution", 3780, 150, 7);
        Employee emp1 = new Employee("Karakus, Zana", 300, pro1, "Information Technology", "IT" );
        Employee emp2 = new Employee("Rocca, Denis", 200, pro1, "Human Resources", "HR" );
        Employee emp3 = new Employee("Anders, Jamie", 250, pro1, "Human Resources", "HR" );
        Employee emp4 = new Employee(emp1);

        Employee[] empLst = {emp1, emp2, emp3, emp4};
        System.out.println("Employees: ");
        for( Employee emp : empLst){
            System.out.println(emp.toString());
            System.out.println();
        }

        ArrayList<Department> deptLst = new ArrayList<Department>();
        for(int i = 0; i < empLst.length; i++){
            if(!deptLst.contains(empLst[i].getDepartment())){
                deptLst.add(empLst[i].getDepartment());
            }
        }    
        for( int i = 0; i < deptLst.size(); i++ ){
            System.out.println("Employees with Matching Departments"+ "(" + (i+1) + ")\n");
            for( int j = 0; j < empLst.length; j++ ){
                if(deptLst.get(i).equals(empLst[j].getDepartment())){
                    System.out.println(empLst[j].toString());
                    System.out.println();
                }
            }
        }
        System.out.println("-------------End Employee List---------------");
    }
}