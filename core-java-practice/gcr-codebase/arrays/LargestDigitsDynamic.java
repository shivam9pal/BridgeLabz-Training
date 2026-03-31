package week01.arrays.level2;

import java.util.Scanner;

public class LargestDigitsDynamic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take user input for number
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();
        
        // Define array to store digits
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        
        // Create index variable
        int index = 0;
        
        // Extract digits from the number
        long tempNumber = Math.abs(number); 
        while (tempNumber != 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                
                // Create new temp array of size maxDigit
                int[] temp = new int[maxDigit];
                
                // Copy from current digits array to temp array
                for (int i = 0; i < index; i++) {
                    temp[i] = digits[i];
                }
                
                // Assign temp array to digits array
                digits = temp;
                
                System.out.println("Array size increased to " + maxDigit);
            }
            
            // Remove last digit and add to array
            digits[index] = (int)(tempNumber % 10);
            tempNumber = tempNumber / 10;
            index++;
        }
        
        // Variables to store largest and second largest
        int largest = 0;
        int secondLargest = 0;
        
        // Find largest and second largest
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        
        // Display results
        System.out.println("\nTotal digits: " + index);
        System.out.println("Digits in the number:");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i] + " ");
        }
        System.out.println("\n\nLargest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
        
        scanner.close();
    }
}
