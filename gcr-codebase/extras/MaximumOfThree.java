package week01.extrasBuiltInFunction;

import java.util.Scanner;

public class MaximumOfThree {
    // Method to find maximum of three numbers
    public static int findMaximum(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    // Method to take input
    public static int[] takeInput() {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[3];
        System.out.print("Enter first number: ");
        numbers[0] = sc.nextInt();
        System.out.print("Enter second number: ");
        numbers[1] = sc.nextInt();
        System.out.print("Enter third number: ");
        numbers[2] = sc.nextInt();
        return numbers;
    }

    public static void main(String[] args) {
        int[] number = takeInput();
        int max = findMaximum(number[0], number[1], number[2]);
        //Displaying the maximum
        System.out.println("Maximum of the three numbers is: " + max);
    }
}
