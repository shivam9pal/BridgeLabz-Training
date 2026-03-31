package week01.programmingElements;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taken user Input
        System.out.print("Enter first number: ");
        double n1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double n2 = sc.nextDouble();
        // Printing the results
        System.out.println("Addition: " + (n1 + n2));
        System.out.println("Subtraction: " + (n1 - n2));
        System.out.println("Multiplication: " + (n1 * n2));
        System.out.println("Division: " + (n1 / n2));
    }
}
