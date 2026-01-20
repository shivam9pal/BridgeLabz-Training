package week04.gcrcodebase.generics.university;

/**
 * Assignment-based course evaluation type
 */
public class AssignmentCourse extends CourseType {
    private int numberOfAssignments;
    private int projectWeight;

    public AssignmentCourse(String courseName, String courseCode, int credits, 
                           int numberOfAssignments, int projectWeight) {
        super(courseName, courseCode, credits);
        this.numberOfAssignments = numberOfAssignments;
        this.projectWeight = projectWeight;
    }

    public int getNumberOfAssignments() {
        return numberOfAssignments;
    }

    public int getProjectWeight() {
        return projectWeight;
    }

    @Override
    public String getEvaluationType() {
        return "Assignment-Based";
    }

    @Override
    public void displayEvaluationDetails() {
        System.out.println("  Evaluation: " + numberOfAssignments + " assignments + Final Project (" + 
                         projectWeight + "%)");
    }
}
