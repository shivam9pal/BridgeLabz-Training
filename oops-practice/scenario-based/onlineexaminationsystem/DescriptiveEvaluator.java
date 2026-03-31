package week02.scenario.onlineexaminationsystem;

public class DescriptiveEvaluator implements EvaluationStrategy {

    @Override
    public double evaluateAnswer(Question question, String studentAnswer) {
        if (!(question instanceof DescriptiveQuestion)) {
            return 0;
        }

        DescriptiveQuestion descQuestion = (DescriptiveQuestion) question;

        if (studentAnswer == null || studentAnswer.isEmpty()) {
            return 0;
        }

        // Validate answer format and length
        if (!descQuestion.validateAnswer(studentAnswer)) {
            return 0; // Invalid answer (word limit not met)
        }

        // For descriptive questions, return maximum marks (manual evaluation needed)
        // In real scenario, this would be evaluated by teacher
        System.out.println("   [Descriptive Answer - Pending Manual Evaluation]");
        return question.getMarks(); // Default full marks, can be adjusted by teacher
    }

    @Override
    public String getEvaluationType() {
        return "Descriptive Evaluation (Manual Review)";
    }

    // Method for teacher to assign marks
    public double assignMarks(Question question, double marksAwarded) {
        if (marksAwarded < 0 || marksAwarded > question.getMarks()) {
            throw new IllegalArgumentException("Marks must be between 0 and " + question.getMarks());
        }
        return marksAwarded;
    }
}
