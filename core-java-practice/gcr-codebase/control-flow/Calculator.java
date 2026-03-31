package week01.flowControl.level3;

import java.util.Scanner;


public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double first, second;
        String op;
        
        // Get input values 
        System.out.print("Enter first number: ");
        first = scanner.nextDouble();
        
        System.out.print("Enter second number: ");
        second = scanner.nextDouble();
        
        System.out.print("Enter operator (+, -, *, /): ");
        op = scanner.next();
        
        // Based on the input value of the op, perform specific operations using the switch...case
        switch (op) {
            case "+":
                System.out.println("Result: " + (first + second));
                break;
            case "-":
                System.out.println("Result: " + (first - second));
                break;
            case "*":
                System.out.println("Result: " + (first * second));
                break;
            case "/":
                if (second != 0) {
                    System.out.println("Result: " + (first / second));
                } else {
                    System.out.println("Error: Division by zero");
                }
                break;
            default:
                System.out.println("Invalid Operator");
        }
        
        scanner.close();
    }
}
