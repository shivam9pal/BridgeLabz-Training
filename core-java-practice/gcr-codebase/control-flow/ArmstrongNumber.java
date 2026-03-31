package week01.flowControl.level3;

import java.util.Scanner;


public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking user input         
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int originalNumber = number;
        int sum = 0;
        
        // Use while loop till the originalNumber is not equal to zero
        while (number != 0) {
            int digit = number % 10;
            sum = sum + (digit * digit * digit);
            number = number / 10;
        }
        
        // Finally check if the sum and the original number. If same an Armstrong number
        if (sum == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong Number");
        } else {
            System.out.println(originalNumber + " is not an Armstrong Number");
        }
        
        scanner.close();
    }
}
