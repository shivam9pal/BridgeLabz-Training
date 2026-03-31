package week01.flowControl.level2;

import java.util.Scanner;

public class GreatestFactorWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking user input        
        System.out.println(" Greatest Factor (While Loop) ");
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        int greatestFactor = 1;
        int counter = number - 1;
        //Greatest Fcatore usind the while loop
        while (counter >= 1) {
            if (number % counter == 0) {
                greatestFactor = counter;
                break;
            }
            counter--;
        }
        
        System.out.println("Greatest factor of " + number + " (beside itself): " + greatestFactor);
        
        scanner.close();
    }
}
