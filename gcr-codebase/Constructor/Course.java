package week02.gcrCodebase.constructor;

public class Course {
	// Instance variable
    String courseName;    
    int duration;         
    double fee;           

    // Class variable
    static String instituteName = "BridgeLabz"; 
    //constructor
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    void displayCourseDetails() {
        System.out.println(courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: " + fee);
        System.out.println("Institute: " + instituteName);
    }

    // Class method
    static void updateInstituteName(String name) {
        instituteName = name;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java", 12, 15000);
        Course c2 = new Course("Python", 10, 12000);

        Course.updateInstituteName("BridgeLabz Solutions");

        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
    }
}

