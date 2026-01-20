package week04.gcrcodebase.generics.university;

/**
 * Research-based course evaluation type
 */
public class ResearchCourse extends CourseType {
    private String researchTopic;
    private int presentationWeight;

    public ResearchCourse(String courseName, String courseCode, int credits, 
                         String researchTopic, int presentationWeight) {
        super(courseName, courseCode, credits);
        this.researchTopic = researchTopic;
        this.presentationWeight = presentationWeight;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public int getPresentationWeight() {
        return presentationWeight;
    }

    @Override
    public String getEvaluationType() {
        return "Research-Based";
    }

    @Override
    public void displayEvaluationDetails() {
        System.out.println("  Evaluation: Research Paper + Presentation (" + presentationWeight + "%)");
        System.out.println("  Research Topic: " + researchTopic);
    }
}
