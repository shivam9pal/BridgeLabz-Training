package week02.gcrcodebase.abstractinterface;

import java.util.ArrayList;
import java.util.List;

interface Department{
	//interface methods 
	void assignDepartment(String deptName);
	String getDepartmentDetails();
}

//abstract class employye
abstract class Employee{
	
	private String employeeId;
	private String name;
	private double baseSalary;
	//constructor 
	Employee(String employeeId,String name,double baseSalary){
		this.baseSalary=baseSalary;
		this.name=name;
		this.employeeId=employeeId;
	}
	//getter and setter
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	//abstract method for calculate salary
	public abstract double calculateSalary();
	
	//concrete method to display details
	public void displayDetails() {
		 System.out.printf("Employee ID   : %s%n", employeeId);
		 System.out.printf("Employee Name : %s%n", name);
		 System.out.printf("Base Salary   : %.2f%n", baseSalary);
	}
}

//fulltime employee inherit employee
class FullTimeEmployee extends Employee implements Department {
	
	private String department;
	FullTimeEmployee(String employeeId,String name,double baseSalary){
		super(employeeId,name,baseSalary);
	}
	//implementing abstract method 
	@Override
	public double calculateSalary() {
		return getBaseSalary();
	}
	
	//implementing Departments method
	@Override
	public void assignDepartment(String deptName) {
		this.department=deptName;
	}	
	 @Override
	 public String getDepartmentDetails() {
	        return department;
	    }
		
}

class PartTimeEmployee extends Employee implements Department {
	
	private int workedHours;
	private double ratePerHour;
	private String department;
	
	PartTimeEmployee(String employeeId,String name,double baseSalary,int workedHours,
			double ratePerHour){
		super(employeeId,name,baseSalary);
		this.workedHours=workedHours;
		this.ratePerHour=ratePerHour;
	}
	//implementing abstract method 
	@Override
	public double calculateSalary() {
		return workedHours*ratePerHour;
	}
	
	//implementing Departments method
	@Override
	public void assignDepartment(String deptName) {
		this.department=deptName;
	}
	 @Override
	 public String getDepartmentDetails() {
	        return department;
	    }
	
	
}
public class EmployeeManagementSystem {

	public static void main(String[] args) {
		Employee employe1=new FullTimeEmployee("EMP101", "Shivam", 50000);
		Employee employe2=new PartTimeEmployee("EMP102", "Rahul", 0, 120, 300);
		//downcasting
		((Department) employe1).assignDepartment("IT");
        ((Department) employe2).assignDepartment("HR");
        
        //to store employee
        List<Employee> employees = new ArrayList<>();
        employees.add(employe1);
        employees.add(employe2);
        
        for(Employee e:employees) {
        	e.displayDetails();
        	System.out.printf("Department    : %s%n",((Department)e).getDepartmentDetails());
                    
            System.out.printf("Total Salary  : %.2f%n",e.calculateSalary());
                    
        }
        
        
        
	}

}
