package week01.method;

import java.util.Scanner;

public class MinMax {
   // find smallest and largest numbers
    public static void findSmallestAndLargest(int a, int b, int c) {

        int smallest = a;
        int largest = a;

        if (b < smallest) {
            smallest = b;
        }
        if (c < smallest) {
            smallest = c;
        }

        if (b > largest) {
            largest = b;
        }
        if (c > largest) {
            largest = c;
        }

        System.out.println("Smallest number: " + smallest+ "  Largest number: " + largest);
        }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        System.out.print("Enter third number: ");
        int num3 = sc.nextInt();
        sc.close();
        findSmallestAndLargest(num1, num2, num3);
    }
}
