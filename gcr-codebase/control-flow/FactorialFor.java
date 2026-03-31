package week01.flowControl.level1;

import java.util.Scanner;

public class FactorialFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Take number from user
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        
        // Check for positive integer
        if (number < 0) {
            System.out.println("Please enter a positive integer");
        } else {
            long factorial = 1;
            
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            
            System.out.println("Factorial of " + number + " is " + factorial);
        }
        
        scanner.close();
    }
}
