package week02.scenario.onlineexaminationsystem;

public abstract class Question {

    protected int questionId;
    protected String questionText;
    protected int marks;
    protected String questionType;

    public Question(int questionId, String questionText, int marks, String questionType) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.marks = marks;
        this.questionType = questionType;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public int getMarks() {
        return marks;
    }

    public String getQuestionType() {
        return questionType;
    }

    public abstract void displayQuestion();

    public abstract boolean validateAnswer(String answer);
}
