package week04.gcrcodebase.generics.university;

/**
 * Exam-based course evaluation type
 */
public class ExamCourse extends CourseType {
    private int midtermWeight;
    private int finalWeight;

    public ExamCourse(String courseName, String courseCode, int credits, int midtermWeight, int finalWeight) {
        super(courseName, courseCode, credits);
        this.midtermWeight = midtermWeight;
        this.finalWeight = finalWeight;
    }

    public int getMidtermWeight() {
        return midtermWeight;
    }

    public int getFinalWeight() {
        return finalWeight;
    }

    @Override
    public String getEvaluationType() {
        return "Exam-Based";
    }

    @Override
    public void displayEvaluationDetails() {
        System.out.println("  Evaluation: Midterm (" + midtermWeight + "%) + Final Exam (" + finalWeight + "%)");
    }
}
