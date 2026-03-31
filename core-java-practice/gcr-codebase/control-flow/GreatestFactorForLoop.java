package week01.flowControl.level2;

import java.util.Scanner;

public class GreatestFactorForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking user input         
        System.out.println(" Greatest Factor (For Loop) ");
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        int greatestFactor = 1;
        //Finding the greatest Factor using %
        for (int i = number - 1; i >= 1; i--) {
            if (number % i == 0) {
                greatestFactor = i;
                break;
            }
        }
        
        System.out.println("Greatest factor of " + number + " (beside itself): " + greatestFactor);
        
        scanner.close();
    }
}
