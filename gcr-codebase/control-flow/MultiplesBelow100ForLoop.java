package week01.flowControl.level2;

import java.util.Scanner;

public class MultiplesBelow100ForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking user input      
        System.out.println(" Multiples Below 100 (For Loop) ");
        System.out.print("Enter a positive integer less than 100: ");
        int number = scanner.nextInt();
        
        if (number <= 0 || number >= 100) {
            System.out.println("Please enter a positive integer less than 100.");
            scanner.close();
            return;
        }
        // Calculating and printing the Multipile below 100
        System.out.println("Multiples of " + number + " below 100:");
        for (int i = 100; i >= 1; i--) {
            if (i % number == 0) {
                System.out.println(i);
            }
        }
        
        scanner.close();
    }
}
