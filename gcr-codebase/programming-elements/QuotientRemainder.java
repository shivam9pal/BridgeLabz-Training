package week01.programmingElements.level2;

import java.util.Scanner;

public class QuotientRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // taking user input 
        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();
        // Performing operations
        int quotient = number1 / number2;
        int remainder = number1 % number2;
        // Displaying the result 
        System.out.println("The Quotient is " + quotient 
                + " and Reminder is " + remainder 
                + " of two number " + number1 + " and " + number2);
    }
}
