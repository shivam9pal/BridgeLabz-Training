package week01.flowControl.level2;

import java.util.Scanner;

public class FindFactorsWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking user input 
        System.out.println(" Find Factors (While Loop) ");
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            scanner.close();
            return;
        }
        // Diplaying the Result
        System.out.println("Factors of " + number + ":");
        int counter = 1;
        while (counter <= number) {
            if (number % counter == 0) {
                System.out.println(counter);
            }
            counter++;
        }
        
        scanner.close();
    }
}
