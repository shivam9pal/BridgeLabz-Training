package week04.gcrcodebase.exception;

import java.util.Scanner;

public class ArrayOperation {

    static void printValue(int[] arr, int index) {
        try {
            System.out.println("Value at index " + index + " is: " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index is out of range.");
        } catch (NullPointerException e) {
            System.out.println("Error: Array is null.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter array size: ");
            int size = sc.nextInt();

            int[] arr = new int[size];

            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.print("Enter index to retrieve value: ");
            int index = sc.nextInt();

            printValue(arr, index);

        } catch (Exception e) {
            System.out.println("Invalid input.");
        } finally {
            sc.close();
        }
    }
}

