package week02.scenario;

class InvalidScoreException extends Exception {

    public InvalidScoreException(String message) {
        super(message);
    }
}
public class StudentScoreAnalyzer {
	// validate scores
    private static void validateScores(int[] scores) throws InvalidScoreException {
        for (int score : scores) {
            if (score < 0 || score > 100) {
                throw new InvalidScoreException(
                        "Invalid score found: " + score + ". Score must be between 0 and 100."
                );
            }
        }
    }
    
 // calculate average
    public static double calculateAverage(int[] scores) throws InvalidScoreException {
        validateScores(scores);

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }
    
 // find maximum score
    public static int findMax(int[] scores) throws InvalidScoreException {
        validateScores(scores);

        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }
 // find minimum score
    public static int findMin(int[] scores) throws InvalidScoreException {
        validateScores(scores);

        int min = scores[0];
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }

	public static void main(String[] args) {
		int[] scores = {85, 90, 78, 92, 88};

        try {
            System.out.println("Average Score : " +calculateAverage(scores));        
            System.out.println("Highest Score : " +findMax(scores));
            System.out.println("Lowest Score  : " +findMin(scores));
        } catch (InvalidScoreException e) {
            System.out.println("Error: " + e.getMessage());
        }

	}

}
