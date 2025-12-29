package week01.extrasBuiltInFunction;

import java.util.Scanner;

public class UserCalculator {
    //for addition
    public static double add(double a, double b) {
        return a + b;
    }
    //for subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }
    //for multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }
    //for division
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Division by zero is not allowed.");
            return 0;
        }
        return a / b;
    }

    //take user input
    public static double[] userInput() {
        Scanner sc = new Scanner(System.in);
        double[] numbers = new double[2];
        System.out.print("Enter first number: ");
        numbers[0] = sc.nextDouble();
        System.out.print("Enter second number: ");
        numbers[1] = sc.nextDouble();

        return numbers;
    }
    //display result
    public static void displayResult(double result) {
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Taking user input for operation
        System.out.println("  Basic Calculator  ");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Choose an operation: ");
        int choice = sc.nextInt();
        double[] values = userInput();
        double result = 0;
        switch (choice) {
            case 1:
                result = add(values[0], values[1]);
                break;
            case 2:
                result = subtract(values[0], values[1]);
                break;
            case 3:
                result = multiply(values[0], values[1]);
                break;
            case 4:
                result = divide(values[0], values[1]);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        //Displaying result
        displayResult(result);
    }
}
