package week02.scenario.onlineexaminationsystem;

public class ObjectiveEvaluator implements EvaluationStrategy {

    @Override
    public double evaluateAnswer(Question question, String studentAnswer) {
        if (!(question instanceof ObjectiveQuestion)) {
            return 0;
        }

        ObjectiveQuestion objQuestion = (ObjectiveQuestion) question;

        if (studentAnswer == null || studentAnswer.isEmpty()) {
            return 0;
        }

        // Check if answer is correct
        if (objQuestion.validateAnswer(studentAnswer)) {
            return question.getMarks();
        } else {
            return 0; // No partial marks for objective
        }
    }

    @Override
    public String getEvaluationType() {
        return "Objective Evaluation (Auto)";
    }
}
