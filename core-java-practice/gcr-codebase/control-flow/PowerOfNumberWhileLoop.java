package week01.flowControl.level2;

import java.util.Scanner;

public class PowerOfNumberWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking user input for Bonus and salary        
        System.out.println(" Power of Number (While Loop) ");
        System.out.print("Enter the base number: ");
        int number = scanner.nextInt();
        System.out.print("Enter the power: ");
        int power = scanner.nextInt();
        
        if (power < 0) {
            System.out.println("Please enter a positive integer for power.");
            scanner.close();
            return;
        }
        //Checking the power
        int result = 1;
        int counter = 0;
        while (counter < power) {
            result *= number;
            counter++;
        }
        //Printing the power and number
        System.out.println(number + " raised to the power " + power + " = " + result);
        
        scanner.close();
    }
}
