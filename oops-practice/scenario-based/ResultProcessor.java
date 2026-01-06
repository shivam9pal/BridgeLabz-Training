package week02.scenario;
import java.util.ArrayList;
import java.util.List;

class InvalidQuizSubmissionException extends Exception {
    InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

class QuizProcessor {

    // validate submission
    private static void validateSubmission(String[] correctAnswers, String[] userAnswers)throws InvalidQuizSubmissionException{
    	if (correctAnswers.length != userAnswers.length) {
            throw new InvalidQuizSubmissionException(
                    "Answer count mismatch. Expected " +
                    correctAnswers.length + " but got " +
                    userAnswers.length
            );
        }
    }

    // calculate score
    public static int calculateScore(String[] correctAnswers,String[] userAnswers)throws InvalidQuizSubmissionException {
        validateSubmission(correctAnswers, userAnswers);

        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }
        return score;
    }

    // return grade
    public static String getGrade(int score, int totalQuestions) {
        double percentage = (double) score / totalQuestions * 100;
        if (percentage >= 90) return "A";
        else if (percentage >= 75) return "B";
        else if (percentage >= 60) return "C";
        else return "D";
    }

    // process quiz for one user
    public static void processResult(String[] correctAnswers,String[] userAnswers,List<Integer> scoreList)throws InvalidQuizSubmissionException {
        int score = calculateScore(correctAnswers, userAnswers);
        scoreList.add(score);

        String grade = getGrade(score, correctAnswers.length);

        System.out.println("Score : " + score + "/" + correctAnswers.length);
        System.out.println("Grade : " + grade);
    }
}


public class ResultProcessor {

	public static void main(String[] args) {
		String[] correctAnswers = {"A", "B", "C", "D", "A"};

        List<Integer> scores = new ArrayList<>();

        try {
            // user 1
            String[] user1Answers = {"A", "B", "C", "D", "A"};
            QuizProcessor.processResult(correctAnswers, user1Answers, scores);
            System.out.println("");
            String[] user2Answers = {"A", "C", "C", "D", "B"};
            QuizProcessor.processResult(correctAnswers, user2Answers, scores);

            System.out.println("");

            String[] user3Answers = {"A", "B", "C"};
            QuizProcessor.processResult(correctAnswers, user3Answers, scores);

        } catch (InvalidQuizSubmissionException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("All Scores: " + scores);

	}

}
