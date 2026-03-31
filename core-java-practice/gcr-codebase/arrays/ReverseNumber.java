package week01.arrays.level2;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take user input for number
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();
        
        // Find count of digits
        long tempNumber = Math.abs(number);
        int digitCount = 0;
        long temp = tempNumber;
        
        if (temp == 0) {
            digitCount = 1;
        } else {
            while (temp != 0) {
                temp = temp / 10;
                digitCount++;
            }
        }
        
        // Find digits and save in array
        int[] digits = new int[digitCount];
        int index = 0;
        
        if (tempNumber == 0) {
            digits[0] = 0;
        } else {
            while (tempNumber != 0) {
                digits[index] = (int)(tempNumber % 10);
                tempNumber = tempNumber / 10;
                index++;
            }
        }
        
        // Create array to store elements in reverse order
        int[] reversedDigits = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            reversedDigits[i] = digits[digitCount - 1 - i];
        }
        
        // Display the original number
        System.out.println("\nOriginal number: " + number);
        
        // Display digits in original order
        System.out.print("Digits (stored order): ");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(digits[i] + " ");
        }
        
        // Display array in reverse order
        System.out.print("\n\nReversed number: ");
        if (number < 0) {
            System.out.print("-");
        }
        for (int i = 0; i < digitCount; i++) {
            System.out.print(reversedDigits[i]);
        }
        System.out.println();
        
        scanner.close();
    }
}
