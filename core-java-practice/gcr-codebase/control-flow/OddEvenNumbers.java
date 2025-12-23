package week01.flowControl.level2;

import java.util.Scanner;

public class OddEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking user input 
        System.out.println(" Print Odd/Even Numbers ");
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();
        
        if (number <= 0) {
            System.out.println("Please enter a natural number (positive integer).");
            scanner.close();
            return;
        }
        //Displaying the odd even numbers in a given range 
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " is even");
            } else {
                System.out.println(i + " is odd");
            }
        }
        
        scanner.close();
    }
}
