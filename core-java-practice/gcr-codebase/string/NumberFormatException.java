package week01.string.level1;

import java.util.Scanner;
public class NumberFormatException {
	
	public static void genrateException(String userInput) {
		
		int number=Integer.parseInt(userInput);
		System.out.println(number);
	}
	
	public static void handleException(String userInput){
		try {
			//checking Exception 
			int number=Integer.parseInt(userInput);
			System.out.println(number);
		}catch(java.lang.NumberFormatException e){
			System.out.println( "Caught Number Fomat Exception "+e.getMessage());
		}catch(java.lang.Exception e) {
			System.out.println( "Caught Number Fomat Exception "+e.getMessage());
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Taking User Input
		System.out.print("Enter the String :");
		String userInput=sc.nextLine();
		
		// Genrate Exception
		genrateException(userInput);
		
		// Handle Exception
		handleException(userInput);
		
		
		

	}

}
