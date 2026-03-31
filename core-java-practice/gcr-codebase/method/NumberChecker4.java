package week01.method;

import java.util.Scanner;

public class NumberChecker4 {

    //check Prime Number
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    // Neon number
    public static boolean isNeonNumber(int number) {
        int square = number * number;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
    }
    //check Spy Number
    public static boolean isSpyNumber(int number) {
        number = Math.abs(number);
        int sum = 0;
        int product = 1;
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            product *= digit;
            number /= 10;
        }
        return sum == product;
    }

    //Automorphic Number
    public static boolean isAutomorphicNumber(int number) {
        int square = number * number;
        return String.valueOf(square).endsWith(String.valueOf(number));
    }

    //Buzz Number
    public static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        System.out.println("\nIs Prime Number: " + isPrime(number));
        System.out.println("Is Neon Number: " + isNeonNumber(number));
        System.out.println("Is Spy Number: " + isSpyNumber(number));
        System.out.println("Is Automorphic Number: " + isAutomorphicNumber(number));
        System.out.println("Is Buzz Number: " + isBuzzNumber(number));

        scanner.close();
    }
}
