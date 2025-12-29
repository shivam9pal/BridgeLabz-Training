package week01.extrasBuiltInFunction;

import java.util.Scanner;

public class FactorialCal{
    //take user input
    public static int userInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to calculate factorial: ");
        return sc.nextInt();
    }
    // Recursion to calculate factorial
    public static long calculateFactorial(int num) {
   
        if (num == 0 || num == 1) {
            return 1;
        }
        // Recursive call
        return num * calculateFactorial(num - 1);
    }
    //display result
    public static void displayResult(int num, long result) {
        System.out.println("Factorial of " + num + " is: " + result);
    }

    public static void main(String[] args) {
        int number = userInput();
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long factorial = calculateFactorial(number);
            displayResult(number, factorial);
        }
    }
}
