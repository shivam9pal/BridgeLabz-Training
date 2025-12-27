package week01.method;

import java.util.Scanner;

public class NmberAnalyze{

    //is positive
    public static boolean isPositive(int number) {
        return number >= 0;
    }
    //is even
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    //compare two numbers
    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        // Take user input
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        // Analyze each number
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];

            if (isPositive(num)) {
                if (isEven(num)) {
                    System.out.println(num + " is Positive and Even");
                } else {
                    System.out.println(num + " is Positive and Odd");
                }
            } else {
                System.out.println(num + " is Negative");
            }
        }

        // Compare first and last elements
        int comparison = compare(numbers[0], numbers[numbers.length - 1]);

        System.out.println("Comparison of first and last elements:");
        if (comparison == 1) {
            System.out.println("First element is Greater than Last element");
        } else if (comparison == 0) {
            System.out.println("First element is Equal to Last element");
        } else {
            System.out.println("First element is Less than Last element");
        }

        scanner.close();
    }
}
