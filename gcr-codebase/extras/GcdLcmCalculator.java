package week01.extrasBuiltInFunction;

import java.util.Scanner;

public class GcdLcmCalculator {
    // Method to take user input
    public static int[] userInput() {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[2];
        System.out.print("Enter first number: ");
        numbers[0] = sc.nextInt();
        System.out.print("Enter second number: ");
        numbers[1] = sc.nextInt();

        return numbers;
    }

    //calculate GCD 
    public static int calculateGCD(int a, int b) {

        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }

    //calculate LCM
    public static int calculateLCM(int a, int b) {

        return (a * b) / calculateGCD(a, b);
    }
    //display result
    public static void displayResult(int a, int b, int gcd, int lcm) {
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
        System.out.println("LCM of " + a + " and " + b + " is: " + lcm);
    }

    public static void main(String[] args) {
        int[] values = userInput();
        int a = values[0];
        int b = values[1];
        int gcd = calculateGCD(a, b);
        int lcm = calculateLCM(a, b);

        displayResult(a, b, gcd, lcm);
    }
}
