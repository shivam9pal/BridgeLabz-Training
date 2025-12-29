package week01.extrasBuiltInFunction;

import java.util.Scanner;

public class PalindromeChecker {

    //user input
    public static String userInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to check palindrome: ");
        return sc.nextLine();
    }
    //check if string is palindrome
    public static boolean isPalindrome(String input) {
    	String userInput=input.trim();
    	StringBuilder sb=new StringBuilder(userInput);
    	sb.reverse();
    	if(userInput.equals(sb.toString())) {
    		return true;
    	}else {
    		return false;
    	}
    }

    //display result
    public static void displayResult(boolean result) {
        if (result) {
            System.out.println("The given string is a PALINDROME");
        } else {
            System.out.println("The given string is NOT a palindrome");
        }
    }

    public static void main(String[] args) {

        String input = userInput();
        boolean result = isPalindrome(input);
        displayResult(result);
    }
}
