package week02.gcrCodebase.constructor;

class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    // Public method to modify salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

// Subclass
public class Manager extends Employee {

    void displayEmployee() {
    	 // public
        System.out.println("Employee ID: " + employeeID);
     // protected
        System.out.println("Department: " + department);  
     // private via method
        System.out.println("Salary: " + getSalary());     
    }

    public static void main(String[] args) {
        Manager m = new Manager();
        m.employeeID = 501;
        m.department = "IT";
        m.setSalary(85000);

        m.displayEmployee();
    }
}

