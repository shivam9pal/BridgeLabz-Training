package week02.scenario.onlineexaminationsystem;

public class DescriptiveQuestion extends Question {

    private String sampleAnswer;
    private int wordLimitMin;
    private int wordLimitMax;

    public DescriptiveQuestion(int questionId, String questionText, int marks,
            String sampleAnswer, int wordLimitMin, int wordLimitMax) {
        super(questionId, questionText, marks, "Descriptive");
        this.sampleAnswer = sampleAnswer;
        this.wordLimitMin = wordLimitMin;
        this.wordLimitMax = wordLimitMax;
    }

    public String getSampleAnswer() {
        return sampleAnswer;
    }

    public int getWordLimitMin() {
        return wordLimitMin;
    }

    public int getWordLimitMax() {
        return wordLimitMax;
    }

    @Override
    public void displayQuestion() {
        System.out.println("\nQ" + questionId + ". (" + marks + " marks) " + questionText);
        System.out.println("   Word Limit: " + wordLimitMin + " - " + wordLimitMax + " words");
    }

    @Override
    public boolean validateAnswer(String answer) {
        String[] words = answer.trim().split("\\s+");
        int wordCount = words.length;
        return wordCount >= wordLimitMin && wordCount <= wordLimitMax && answer.length() > 10;
    }

    public int countWords(String answer) {
        if (answer == null || answer.isEmpty()) {
            return 0;
        }
        return answer.trim().split("\\s+").length;
    }
}
