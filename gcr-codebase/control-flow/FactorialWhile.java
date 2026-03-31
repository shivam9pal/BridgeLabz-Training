package week01.flowControl.level1;

import java.util.Scanner;

public class FactorialWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        
        // Check for positive integer
        if (number < 0) {
            System.out.println("Please enter a positive integer");
        } else {
            long factorial = 1;
            int i = 1;
            
            while (i <= number) {
                factorial *= i;
                i++;
            }
            
            System.out.println("Factorial of " + number + " is " + factorial);
        }
        
        scanner.close();
    }
}
