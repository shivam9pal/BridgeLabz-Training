package week01.flowControl.level3;

import java.util.Scanner;


public class CountDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        
        // Handle negative numbers
        number = Math.abs(number);
        
        // Create an integer variable count with value 0
        int count = 0;
        
        // Special case for 0
        if (number == 0) {
            count = 1;
        } else {
            while (number != 0) {
                number = number / 10;
                count++;
            }
        }
        
        // display the count to show the number of digits
        System.out.println("Number of digits: " + count);
        
        scanner.close();
    }
}
