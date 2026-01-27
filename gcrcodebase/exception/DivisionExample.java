package week04.gcrcodebase.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            int result = a / b;   // may cause ArithmeticException
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter numeric values only.");

        } finally {
            sc.close();
        }
    }
}

