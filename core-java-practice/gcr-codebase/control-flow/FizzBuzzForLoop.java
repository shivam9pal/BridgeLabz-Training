package week01.flowControl.level2;

import java.util.Scanner;

public class FizzBuzzForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(" FizzBuzz (For Loop) ");
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            scanner.close();
            return;
        }
        // Displaying the result on the basis of condition
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
        
        scanner.close();
    }
}
