public class Department {
    private String deptName;
    private String deptCode;

    public Department( String deptName, String deptCode ){
        this.deptName = deptName;
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public boolean equals( Object obj ){
        if( obj instanceof Department){
            Department dept = (Department) obj;
            if( dept.deptName.equals(this.deptName) &&  dept.deptCode.equals(this.deptCode)){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        return "Dept Name: " + deptName + " Dept Code: " + deptCode;
    }

}
