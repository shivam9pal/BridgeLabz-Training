package week01.flowControl.level2;

import java.util.Scanner;

public class PowerOfNumberForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking user input for Bonus and salary        
        System.out.println(" Power of Number (For Loop) ");
        System.out.print("Enter the base number: ");
        int number = scanner.nextInt();
        System.out.print("Enter the power: ");
        int power = scanner.nextInt();
        
        if (power < 0) {
            System.out.println("Please enter a positive integer for power.");
            scanner.close();
            return;
        }
        
        int result = 1;
        for (int i = 1; i <= power; i++) {
            result *= number;
        }
        //Displaying the Result
        System.out.println(number + " raised to the power " + power + " = " + result);
        
        scanner.close();
    }
}
