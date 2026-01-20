package week04.gcrcodebase.generics.university;

/**
 * Abstract base class for different course types
 */
public abstract class CourseType {
    private String courseName;
    private String courseCode;
    private int credits;

    public CourseType(String courseName, String courseCode, int credits) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCredits() {
        return credits;
    }

    public abstract String getEvaluationType();
    
    public abstract void displayEvaluationDetails();

    @Override
    public String toString() {
        return courseCode + " - " + courseName + " (" + credits + " credits) - " + getEvaluationType();
    }
}
