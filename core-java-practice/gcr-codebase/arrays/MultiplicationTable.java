package week01.arrays.level1;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input number
        System.out.print("Enter a number to print its multiplication table: ");
        int number = scanner.nextInt();
        
        // Define array to store multiplication results
        int[] multiplicationTable = new int[10];
        
        // Store multiplication results from 1 to 10
        for (int i = 1; i <= 10; i++) {
            multiplicationTable[i - 1] = number * i;
        }
        
        // Display the multiplication table
        System.out.println("\nMultiplication Table of " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationTable[i - 1]);
        }
        
        scanner.close();
    }
}
