package week01.flowControl.level2;

import java.util.Scanner;

public class FindFactorsForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking user input
        System.out.println(" Find Factors (For Loop) ");
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        
        
        // Displaying the result on the basis of 
        System.out.println("Factors of " + number + ":");
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.println(i);
            }
        }
        
        scanner.close();
    }
}
