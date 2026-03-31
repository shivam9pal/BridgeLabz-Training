package week02.gcrCodebase.constructor;

class Student {
    public int rollNumber;
    protected String name;
    private double cgpa;

    // Public methods to access private CGPA
    public void setCGPA(double cgpa) {
        this.cgpa = cgpa;
    }

    public double getCGPA() {
        return cgpa;
    }
}

// Subclass
public class PostgraduateStudent extends Student {

    void displayDetails() {
    	// public
        System.out.println("Roll No: " + rollNumber);
        // protected
        System.out.println("Name: " + name);     
        // private via method
        System.out.println("CGPA: " + getCGPA());
    }

    public static void main(String[] args) {
        PostgraduateStudent p = new PostgraduateStudent();
        p.rollNumber = 101;
        p.name = "Shivam";
        p.setCGPA(8.5);

        p.displayDetails();
    }
}

