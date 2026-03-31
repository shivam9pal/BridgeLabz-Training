package week01.arrays.level1;

import java.util.Scanner;

public class MultiplicationTable6To9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input number
        System.out.print("Enter a number to print its multiplication table (6 to 9): ");
        int number = scanner.nextInt();
        
        // Define array to store multiplication results (for 6 to 9, we need 4 elements)
        int[] multiplicationResult = new int[4];
        
        // Calculate and store multiplication results from 6 to 9
        int index = 0;
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[index] = number * i;
            index++;
        }
        
        // Display the results
        System.out.println("\nMultiplication Table of " + number + " from 6 to 9:");
        index = 0;
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[index]);
            index++;
        }
        
        scanner.close();
    }
}
