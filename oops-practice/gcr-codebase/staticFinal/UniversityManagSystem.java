package week02.gcrcodebase.staticfinal;

class Student{
	// Static variables
    private static String universityName = "Global University";
    private static int totalStudents = 0;

    // Final variable
    private final int rollNumber;

    private String name;
    private String grade;
    
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }
    
 // Static method
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }
    
    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated to: " + newGrade);
        }
    }
    
    // Display details
    public void displayStudentDetails() {
        System.out.println("University Name: " + universityName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
    }
}

public class UniversityManagSystem extends Student{

	public UniversityManagSystem(String name, int rollNumber, String grade) {
		super(name, rollNumber, grade);
	}
	
	public static void main(String[] args) {
		UniversityManagSystem s1 =new UniversityManagSystem("Hemashree", 101, "A");
		Student.displayTotalStudents();
        s1.displayStudentDetails();
	}
}
