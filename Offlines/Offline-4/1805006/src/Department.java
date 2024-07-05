public class Department {

    private int id;
    private String name;
    private Employee [] employees;
    private int employeeCount;
    private static Department [] allDept = new Department[20];
    private static int deptCount;
    // add your code here
    // there can be at most 20 departments

    // you are not allowed to write any other constructor
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
        this.employees = new Employee[10];
        allDept[deptCount++] = this;
        // add your code here
    }

    public void addEmployee( Employee e ) {
        employees[employeeCount++] = e;
    }

    public double getDepartmentSalary(){
        double t=0;
        for(int i = 0; i < employeeCount; i++ ) {
            t += employees[i].getSalary();
        }
        return t;
    }

    public Employee getMaxSalaryEmployee(){
        Employee ans = employees[0];

        for(int i = 0; i < employeeCount; i++) {
            if (ans.getSalary() < employees[i].getSalary()) {
                ans = employees[i];
            }
        }
        return ans;
    }

    public static double getTotalSalary()
    {
        double ans=0;
        for( int i=0; i< deptCount; i++ ) {
            ans += allDept[i].getDepartmentSalary();
        }
        return ans;
    }
    // add your code here

}
