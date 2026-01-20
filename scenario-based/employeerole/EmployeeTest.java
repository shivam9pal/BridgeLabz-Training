package week03.scenariobased.employeerole;

class EmployeeTest {
	public static void main(String[] args) {

        Employee manager = new Manager("shivam", 80000);
        System.out.printf("%.2f%n", manager.getBonus());

        Employee dev1 = new Developer("Harish", 60000);
        System.out.printf("%.2f%n", dev1.getBonus()); 

        Employee dev2 = new Developer("Sujal", 40000);
        System.out.printf("%.2f%n", dev2.getBonus()); 
    }
}
