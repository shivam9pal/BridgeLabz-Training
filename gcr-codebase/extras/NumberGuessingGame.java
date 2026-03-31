package week01.extrasBuiltInFunction;
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
	
	//Method for random number between 1-100
	public static int randomNumber(int low,int high) {
		//Generating random number
		Random random=new Random();
		int number=random.nextInt((high-low+1)+low);
		return number;
	}
	
	// getting the feedback of user 
	public static String getFeedback(int guess) {
		Scanner sc=new Scanner(System.in);
		System.out.printf("Is this is your Number %d ?",guess);
		System.out.println("\nEnter the feedback (High/Low or Correct)");
		String feedback=sc.nextLine().toLowerCase();
		return  feedback;
	}
	
	//checking the feedback of user  
	public static boolean processFeedback(String feedback) {
		return feedback.equals("correct");
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Staring game
		System.out.println("Think a number between 1-100 \nI will guess it !");
		int low=1;
		int high=100;
		
		boolean guessCorreclty=false;
		
		while(!guessCorreclty && low <= high) {
			int guessNumber=randomNumber(low,high);
			String feedback=getFeedback(guessNumber);
			guessCorreclty=processFeedback(feedback);
			
			//checking the feedback range
			if(feedback.equals("high")) {
				high=guessNumber-1;
			}else if(feedback.equals("low")) {
				low=guessNumber+1;
			}else if (!feedback.equals("correct")) {
                System.out.println("Invalid input! Please enter high, low, or correct.");
            }
			
		}
		
		System.out.println("Hurray I guessed your Number !..");
		sc.close();
		
	}
}
