package week02.scenario.onlineexaminationsystem;

public class ObjectiveQuestion extends Question {

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;

    public ObjectiveQuestion(int questionId, String questionText, int marks,
            String optionA, String optionB, String optionC, String optionD,
            String correctAnswer) {
        super(questionId, questionText, marks, "Objective");
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer.toUpperCase();
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public void displayQuestion() {
        System.out.println("\nQ" + questionId + ". (" + marks + " marks) " + questionText);
        System.out.println("   A) " + optionA);
        System.out.println("   B) " + optionB);
        System.out.println("   C) " + optionC);
        System.out.println("   D) " + optionD);
    }

    @Override
    public boolean validateAnswer(String answer) {
        return answer.toUpperCase().equals(correctAnswer);
    }
}
