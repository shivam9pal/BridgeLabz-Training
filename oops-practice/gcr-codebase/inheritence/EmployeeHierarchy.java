package week02.gcrcodebase.inheritence;

class Employee{
	String name;
	int id;
	int salary;
	
	Employee(String name,int id,int salary){
		this.name=name;
		this.id=id;
		this.salary=salary;
	}
	
	void displayDetails() {
		System.out.println("Name : "+" "+name+" id : "+" "+id+" Salary : "+salary);
	}
}


class Manager extends Employee{
	int teamSize;
	Manager(String name,int id,int salary,int teamSize){
		super(name,id,salary);
		this.teamSize=teamSize;
	}
	
	void displayDetails() {
		System.out.println("Name : "+" "+name+" id : "+" "+id+" Salary : "+salary+" Manager's TeamSize : "+teamSize);
	}
	
}

class Developer extends Employee{
	String programmingLangugae;
	
	Developer(String name,int id,int salary,String programmingLangugae){
		super(name,id,salary);
		this.programmingLangugae=programmingLangugae;
	}
	void displayDetails() {
		System.out.println("Name : "+" "+name+" id : "+" "+id+" Salary : "+salary+" Developer's Language : "+programmingLangugae);
	}
}

class Intern extends Employee{
	int durationInMonths;

    Intern(String name, int id, int salary, int durationInMonths) {
        super(name, id, salary);
        this.durationInMonths = durationInMonths;
	}
	void displayDetails() {
		System.out.println("Name : "+" "+name+" id : "+" "+id+" Salary : "+salary+" Interns's Duration : "+ durationInMonths);
	}
	
	
}
public class EmployeeHierarchy {

	public static void main(String[] args) {
		Employee e1 = new Manager("Amit", 101, 80000, 10);
        Employee e2 = new Developer("Shivam", 102, 60000, "Java");
        Employee e3 = new Intern("Rahul", 103, 15000, 6);

        e1.displayDetails();
        e2.displayDetails();
        e3.displayDetails();
		

	}

}
