package week02.gcrcodebase.inheritence;

// Base class
class Course {
    String courseName;
    int duration; 

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void displayInfo() {
        System.out.println("Course Name: " + courseName + ", Duration: " + duration + " hours");
    }
}

// Subclass
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    
    void displayInfo() {
        System.out.println("Course Name: " + courseName + ", Duration: " + duration + " hours, Platform: " + platform + ", Recorded: " + isRecorded);
    }
}

// Subclass 
class PaidOnlineCourse extends OnlineCourse {
    int fee;
    int discount; 

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, int fee, int discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    void displayInfo() {
        System.out.println("Course Name: " + courseName + ", Duration: " + duration + " hours, Platform: " + platform + ", Recorded: " + isRecorded + ", Fee: " + fee + ", Discount: " + discount + "%");
    }
}

public class CourseMultiLevel {

    public static void main(String[] args) {

        Course c1 = new Course("Core Java", 40);
        Course c2 = new OnlineCourse("Spring Boot", 50, "Udemy", true);
        Course c3 = new PaidOnlineCourse("Full Stack Java", 120, "Coursera", true, 15000, 20);

        c1.displayInfo();
        c2.displayInfo();
        c3.displayInfo();
    }
}
