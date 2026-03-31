package week01.method;

import java.util.Scanner;

public class ChocolatesChildren {

    // Method to find chocolates per child 
    public static int[] findRemainderAndQuotient(int number, int divisor) {

        int quotient = number / divisor;   
        int remainder = number % divisor;  

        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking user input
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = sc.nextInt();
        System.out.print("Enter the number of children: ");
        int numberOfChildren = sc.nextInt();
        sc.close();

        // Method call
        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        // Display result
        System.out.println("Each child will get " + result[0] + " chocolates.");
        System.out.println("Remaining chocolates: " + result[1]);
    }
}
