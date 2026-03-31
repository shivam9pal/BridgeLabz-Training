package week02.scenario.onlineexaminationsystem;

public interface EvaluationStrategy {

    double evaluateAnswer(Question question, String studentAnswer);

    String getEvaluationType();
}
