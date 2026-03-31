package week01.method;

import java.util.Scanner;

public class NumberChecker2 {

    //count digits in a number
    public static int countDigits(int number) {
        number = Math.abs(number);

        if (number == 0) {
            return 1;
        }

        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    //store digits of the number in an array
    public static int[] getDigitsArray(int number) {
        number = Math.abs(number);
        int count = countDigits(number);
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }
    //find sum of digits
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }
    // sum of squares of digits
    public static double sumOfSquaresOfDigits(int[] digits) {
        double sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }
    //check Harshad number
    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return sum != 0 && number % sum == 0;
    }

    // find frequency of each digit
    public static int[][] digitFrequency(int[] digits) {
        int[][] frequency = new int[10][2];

        
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;
            frequency[i][1] = 0;
        }

        // Count frequency
        for (int digit : digits) {
            frequency[digit][1]++;
        }
        return frequency;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int digitCount = countDigits(number);
        int[] digits = getDigitsArray(number);
        System.out.println("\nDigit Count: " + digitCount);

        System.out.print("Digits Array: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        int sumDigits = sumOfDigits(digits);
        double sumSquares = sumOfSquaresOfDigits(digits);
        System.out.println("\n\nSum of Digits: " + sumDigits);
        System.out.println("Sum of Squares of Digits: " + sumSquares);
        System.out.println("Is Harshad Number: " + isHarshadNumber(number, digits));
        int[][] frequency = digitFrequency(digits);
        System.out.println("\nDigit Frequency:");
        System.out.println("Digit  Frequency");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i][1] > 0) {
                System.out.println(frequency[i][0] + "      " + frequency[i][1]);
            }
        }

        scanner.close();
    }
}
