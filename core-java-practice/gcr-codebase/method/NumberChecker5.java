package week01.method;

import java.util.Scanner;

public class NumberChecker5 {

    // sum of proper divisors
    private static int sumOfProperDivisors(int number) {
        if (number <= 1) {
            return 0;
        }
        int sum = 1; 
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
    //check Perfect Number
    public static boolean isPerfectNumber(int number) {
        if (number <= 1) {
            return false;
        }
        return sumOfProperDivisors(number) == number;
    }
    //Abundant Number
    public static boolean isAbundantNumber(int number) {
        if (number <= 0) {
            return false;
        }
        return sumOfProperDivisors(number) > number;
    }
    //Deficient Number
    public static boolean isDeficientNumber(int number) {
        if (number <= 0) {
            return false;
        }
        return sumOfProperDivisors(number) < number;
    }
    //factorial of a digit
    private static int factorial(int digit) {
        int fact = 1;
        for (int i = 1; i <= digit; i++) {
            fact *= i;
        }
        return fact;
    }
    // Strong Number
    public static boolean isStrongNumber(int number) {
        int originalNumber = number;
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += factorial(digit);
            number /= 10;
        }
        return sum == originalNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        //Displaying Result
        System.out.println("\nIs Perfect Number: " + isPerfectNumber(number));
        System.out.println("Is Abundant Number: " + isAbundantNumber(number));
        System.out.println("Is Deficient Number: " + isDeficientNumber(number));
        System.out.println("Is Strong Number: " + isStrongNumber(number));

        scanner.close();
    }
}
