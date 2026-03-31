package week01.flowControl.level3;

import java.util.Scanner;


public class HarshadNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int originalNumber = number;
        int sum = 0;
        
        // Create a while loop to access each digit of the number
        while (number != 0) {
            // Add each digit of the number to sum
            sum = sum + (number % 10);
            number = number / 10;
        }
        
        // Check if the number is perfectly divisible by the sum
        if (sum != 0 && originalNumber % sum == 0) {
            System.out.println(originalNumber + " is a Harshad Number");
        } else {
            System.out.println(originalNumber + " is Not a Harshad Number");
        }
        
        scanner.close();
    }
}
