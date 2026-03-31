package week01.method;

import java.util.Scanner;

public class SumOfNaturalNumbers {

    //calculate sum of n natural numbers using loop
    public static int calculateSum(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        sc.close();
        int result = calculateSum(n);
        // Display result
        System.out.println("The sum of first " + n + " natural numbers is: " + result);
    }
}
