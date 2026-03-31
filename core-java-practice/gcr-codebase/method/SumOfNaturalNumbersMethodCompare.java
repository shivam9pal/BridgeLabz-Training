package week01.method;

import java.util.Scanner;

public class SumOfNaturalNumbersMethodCompare {

    // sum using recursion
    public static int sumUsingRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumUsingRecursion(n - 1);
    }
    //calculate sum using formula
    public static int sumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Taking user input
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        sc.close();
        if (n <= 0) {
            System.out.println("Please enter a valid natural number (greater than 0).");
            return;
        }
        
        int recursiveSum = sumUsingRecursion(n);
        int formulaSum = sumUsingFormula(n);

        // Display results
        System.out.println("Sum using recursion: " + recursiveSum);
        System.out.println("Sum using formula: " + formulaSum);
        // Compare results
        if (recursiveSum == formulaSum) {
            System.out.println("✅ Both results are correct and match.");
        } else {
            System.out.println("❌ Results do not match.");
        }
    }
}
