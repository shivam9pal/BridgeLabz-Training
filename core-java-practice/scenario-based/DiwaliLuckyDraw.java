package scenarioBased;
import java.util.Scanner;

public class DiwaliLuckyDraw {
	
		public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Using while loop for Multipile users input 
		while(true) {
			// Taken User input\
			System.out.println("Enter the Value");
			int userInput=sc.nextInt();
			sc.nextLine();
			// checking the input is in integer range 
			if(!(userInput>Integer.MIN_VALUE && userInput <Integer.MAX_VALUE)) {
				System.out.println("Invalid Number :"+ userInput);
				continue;
			}
			// Checking winning condition
			if(userInput%3==0 || userInput%5==0) {
				System.out.println("Hurray ! You have Won a gift ");
			}else {
				System.out.println("Better Luck Next Time !");
			}
			
			//Asking Another USER to Pay again
			System.out.print("Want to play Again enter YES or Want to leave Game Exit ");
			String playAgain=sc.nextLine();
			if(playAgain.equals("Exit")) {
				break;
			}
		
		}
	}

}
