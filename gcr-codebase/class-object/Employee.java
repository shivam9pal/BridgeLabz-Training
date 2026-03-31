package week02.gcrCodebase.classObject;

public class Employee {
	//Setting Attributes
	private String name;
    private int id;
    private double salary;
    // To display Attributes
    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee Salary: " + salary);
    }
    
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.name = "Rohan";
        emp.id = 1;
        emp.salary = 500000;
        //Calling Display Mehtod
        emp.displayDetails();
    }

}
