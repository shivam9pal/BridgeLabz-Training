package week03.scenariobased.employeerole;

abstract class Employee {
	private final String name;
    private final double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    
    abstract double getBonus();
}
