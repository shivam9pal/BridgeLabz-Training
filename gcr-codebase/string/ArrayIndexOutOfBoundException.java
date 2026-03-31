package week01.string.level1;

import java.util.Scanner;

public class ArrayIndexOutOfBoundException {

    // Method to  generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] names, int index) {
        System.out.println("--- Attempting to generate an exception ---");
        System.out.println("Accessing index " + index);
        String name = names[index];
        System.out.println("Accessed name: " + name);
    }

    // Method to demonstrate handle exception
    public static void handleException(String[] names, int index) {
        System.out.println("\n--- Demonstrating exception handling with try-catch ---");
        try {
            System.out.println("Attempting to access index " + index);
            String name = names[index];
            System.out.println("Successfully accessed name: " + name);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught an ArrayIndexOutOfBoundsException!");
            System.out.println("Error message: " + e.getMessage());
            System.out.println("The requested index (" + index + ") is outside the valid range (0 to " + (names.length - 1) + ").");
        } catch (RuntimeException e) {
            System.out.println("Caught a generic RuntimeException: " + e.getMessage());
        } finally {
            // This block always executes
            System.out.println("The try-catch block has finished execution.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define an array of names
        String[] names = {"Alice", "Bob", "Charlie", "David"};
        System.out.println("Array of names created with length " + names.length);
        System.out.println("Valid indices are 0, 1, 2, 3.");

        System.out.print("Enter an index larger than the array length (e.g., 4 or higher) to see the exception: ");
        int invalidIndex = scanner.nextInt();

        //  call the method to generate the Exception
        try {
            generateException(names, invalidIndex);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("--- Exception was caught in the main method ---");
            System.out.println("The program would have stopped abruptly here if not caught in main.");
            System.out.println("Error: " + e.getMessage());
        }

        System.out.print("\nEnter an index again (e.g., 4 or higher) to see the handling: ");
        int indexForHandling = scanner.nextInt();

        handleException(names, indexForHandling);

        scanner.close();
    }
}

