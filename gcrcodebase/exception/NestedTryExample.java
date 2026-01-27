package week04.gcrcodebase.exception;

import java.util.Scanner;

public class NestedTryExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Input array size and elements
            System.out.print("Enter array size: ");
            int size = sc.nextInt();

            int[] arr = new int[size];
            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            // Input index and divisor
            System.out.print("Enter index to access: ");
            int index = sc.nextInt();

            System.out.print("Enter divisor: ");
            int divisor = sc.nextInt();

            try {
                int value = arr[index];  // may throw ArrayIndexOutOfBoundsException

                try {
                    int result = value / divisor; // may throw ArithmeticException
                    System.out.println("Result: " + result);

                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }

        } finally {
            sc.close();
        }
    }
}

