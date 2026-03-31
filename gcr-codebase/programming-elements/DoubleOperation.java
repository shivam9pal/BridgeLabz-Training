package week01.programmingElements.level2;

import java.util.Scanner;

public class DoubleOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // taking user input 
        System.out.print("Enter value of a: ");
        double a = sc.nextDouble();
        
        System.out.print("Enter value of b: ");
        double b = sc.nextDouble();

        System.out.print("Enter value of c: ");
        double c = sc.nextDouble();
        // Performing double operation
        double result1 = a + b * c;
        double result2 = a * b + c;
        double result3 = c + a / b;
        double result4 = a % b + c;
        // Displaying the Double Operation Result
        System.out.println("The results of Double Operations are "
                + result1 + ", " + result2 + ", " 
                + result3 + ", and " + result4);
    }
}

