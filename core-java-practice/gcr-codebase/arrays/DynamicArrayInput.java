package week01.arrays.level1;

import java.util.Scanner;

public class DynamicArrayInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Define array 
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        
        System.out.println("Enter numbers (up to 10). Enter 0 or negative to stop:");
        
        //  take user input
        while (true) {
            System.out.print("Enter number " + (index + 1) + ": ");
            double number = scanner.nextDouble();
            
            // Break if user entered 0 or negative number
            if (number <= 0) {
                System.out.println("Stopping input (0 or negative number entered).");
                break;
            }
            
            
            numbers[index] = number;
            index++;
            
            // Break if array is full
            if (index == 10) {
                System.out.println("Maximum 10 numbers reached.");
                break;
            }
        }
        
        // Calculate total
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println("Number " + (i + 1) + ": " + numbers[i]);
            total += numbers[i];
        }
        
        // Display total
        System.out.println("\nSum of all numbers: " + total);
        
        scanner.close();
    }
}
