package week02.scenario;





public class StudentQuizGrader {
	// to check answers and return scores 
	public static int checkAnswers(String[] stdAns, String[] corAns) {
		int score=0;
		
		for(int i=0;i<corAns.length;i++) {
			if(stdAns[i].equalsIgnoreCase(corAns[i])) {
				score++;
                System.out.println("Question " + (i + 1) + ": Correct");
			}else {
				System.out.println("Question " + (i + 1) + ": Incorrect");
			}
		}
		return score;
	}
	public static void main(String[] args) {
		String[] correctAnswers = {"A", "B", "C", "D", "A","C", "B", "D", "A", "C"};
        String[] studentAnswers = {"a", "b", "D", "D", "A","c", "b", "a", "A", "c"};
          //score 
        int score=checkAnswers(studentAnswers,correctAnswers);
        //percentage
        double percentage=score*100/correctAnswers.length;
        //display
        System.out.println("Total Score: " + score + "/" + correctAnswers.length);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println(percentage >= 50 ? "Result: Pass" : "Result: Fail");


	}

}
