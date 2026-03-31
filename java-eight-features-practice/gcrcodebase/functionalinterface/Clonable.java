package week06.gcrcodebase.functionalinterface;


class Employee implements Cloneable {

    String name;
    int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Override clone() method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', id=" + id + "}";
    }
}

class Clonable {
	public static void main(String[] args) {
		 

		        try {
		            // Original object (prototype)
		            Employee emp1 = new Employee("John", 101);

		            // Clone the object
		            Employee emp2 = (Employee) emp1.clone();

		            System.out.println("Original: " + emp1);
		            System.out.println("Cloned:   " + emp2);

		        } catch (CloneNotSupportedException e) {
		            e.printStackTrace();
		        }
		    
	}
}	
