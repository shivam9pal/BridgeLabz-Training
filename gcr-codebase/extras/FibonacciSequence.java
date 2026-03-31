package week01.extrasBuiltInFunction;

import java.util.Scanner;

public class FibonacciSequence {
    // Method for Fibonacci sequence
    public static void genFibonacci(int terms) {
        int first = 0;
        int second = 1;
        System.out.print("Fibonacci Sequence: ");
        for (int i = 1; i <= terms; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
    }
    // take user input
    public static int userInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        return sc.nextInt();
    }

    // Display method
    public static void displayResult(int terms) {
        if (terms <= 0) {
            System.out.println("Please enter a positive number.");
        } else {
            genFibonacci(terms);
        }
    }

    public static void main(String[] args) {

        int terms = userInput();
        displayResult(terms);
    }
}
