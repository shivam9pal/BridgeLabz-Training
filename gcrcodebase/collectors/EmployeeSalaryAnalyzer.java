package collectors;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
	private String name;
	private String department;
	private double salary;

	public Employee(String name, String department, double salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public double getSalary() {
		return salary;
	}
}

public class EmployeeSalaryAnalyzer {

	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(new Employee("Rahul", "IT", 60000), new Employee("Anita", "HR", 45000),
				new Employee("Vikram", "IT", 70000), new Employee("Sneha", "Finance", 55000),
				new Employee("Karan", "HR", 50000));

		Map<String, Double> avgSalaryByDept = employees.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		avgSalaryByDept.forEach((dept, avgSalary) -> System.out.println(dept + " → Average Salary: ₹" + avgSalary));
	}
}
