package week01.flowControl.level1;

import java.util.Scanner;

public class OddEvenPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        // Check for natural number
        if (number <= 0) {
            System.out.println("The number " + number + " is not a natural number");
        } else {
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is even number");
                } else {
                    System.out.println(i + " is odd number");
                }
            }
        }
        
        scanner.close();
    }
}
