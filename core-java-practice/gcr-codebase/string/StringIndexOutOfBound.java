package week01.string.level1;

import java.util.Scanner;

public class StringIndexOutOfBound {

    // A method to generate a StringIndexOutOfBoundsException
    public static void generateException(String inputString) {
        try {
            // Accessing an index that is out of bound 
            char character = inputString.charAt(inputString.length());
            System.out.println("This line will not be reached if exception occurs.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught the exception successfully: " + e.getMessage());
        }
        
    }

    // A method that uses try-catch 
    public static void handleException(String inputString) {
        System.out.println(" Demonstrating exception handling with try-catch");
        try {
           
            System.out.println("Attempting to access character at index " + inputString.length() + " (which is out of bounds)...");
            char character = inputString.charAt(inputString.length());
            System.out.println("Character at index " + inputString.length() + ": " + character); 
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("An exception was caught: " + e.getMessage());
        }
        System.out.println("Exception handling demonstration finished");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string value: ");
        String userInput = scanner.nextLine();
        
        if (userInput.isEmpty()) {
            System.out.println("Input cannot be empty. Exiting program.");
            scanner.close();
            return;
        }

        // Call the method to demonstrate generation and abrupt stop
        generateException(userInput);

        // Call the method to demonstrate handling the exception gracefully
        handleException(userInput);
        
        scanner.close();
    }
}

