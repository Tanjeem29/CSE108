public class Employee {

    private int id;
    private String name;
    private double salary;

    // you are not allowed to write any other constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }
    public void setSalary(double s){
        salary = s;
    }

    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }

    public int getId(){
        return id;
    }
    public void setId(int i){
        id = i;
    }

    // add your code here
}