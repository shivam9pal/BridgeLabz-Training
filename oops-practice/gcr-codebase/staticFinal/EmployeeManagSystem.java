package week02.gcrcodebase.staticfinal;



class Employee{
	static String companyName="BridgeLabz pvt ltd.";
	static int totalEmploy=0;
	final int id;

    String name;
    String designation;
    
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmploy++;
    }
    
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmploy);
    }
    
 // Display details
    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
    }
}


public class EmployeeManagSystem extends Employee {

	public EmployeeManagSystem(String name, int id, String designation) {
		super(name, id, designation);
	}
	
	public static void main(String[] args) {
		Employee emp1 = new Employee("Rohan", 102, "Project Manager");
		Employee.displayTotalEmployees();
        emp1.displayEmployeeDetails();
	}

}
