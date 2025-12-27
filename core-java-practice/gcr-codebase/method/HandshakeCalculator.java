package week01.method;

import java.util.Scanner;

public class HandshakeCalculator {

    // Method to calculate maximum number of handshakes
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();

        sc.close();

        int handshakes = calculateHandshakes(numberOfStudents);

        
        System.out.println(
            "The maximum number of possible handshakes is: " + handshakes
        );
    }
}
