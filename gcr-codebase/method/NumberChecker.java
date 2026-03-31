package week01.method;

import java.util.Scanner;

public class NumberChecker {

    //check the sign of the number
    public static int checkNumberSign(int number) {
        if (number > 0) {
            return 1;      
        } else if (number < 0) {
            return -1;     
        } else {
            return 0;      
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter an integer number: ");
        int number = sc.nextInt();

        sc.close();

        int result = checkNumberSign(number);

        // Displaying result
        if (result == 1) {
            System.out.println("The number is Positive.");
        } else if (result == -1) {
            System.out.println("The number is Negative.");
        } else {
            System.out.println("The number is Zero.");
        }
    }
}
