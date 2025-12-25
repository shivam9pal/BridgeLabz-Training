package week01.string.level1;

import java.util.Scanner;

public class IllegalArgumentException {
	// Exception Generated
	public static void generateException(String strInput) {
		System.out.println("Attempting to generate exception...");
		String subString = strInput.substring(0, strInput.length() + 1);
		System.out.println(subString);
		System.out.println("This Line will not be Executed");
	}
	
	// Handling Exception
	public static void handleException(String strInput) {
		try {
			System.out.println("Attempting to handle exception...");
			String subString = strInput.substring(0, strInput.length() + 1);
			System.out.println(subString);
			System.out.println("This Line will not be Executed inside try block");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index Out Of Bounds Exception caught: " + e.getMessage());
		} finally {
			System.out.println("Yes the finally Block gets Executed");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Taking User Input
		System.out.print("Enter the String: ");
		String userInput = sc.nextLine();
		
		// exception handling
		handleException(userInput);
		
		System.out.println(" Now generating unhandled exception ");
		
		// an unhandled exception 
		generateException(userInput);
		
		sc.close();
	}
}
