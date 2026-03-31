package week01.programmingElements;

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking user input 
        System.out.print("Enter base: ");
        double base = sc.nextDouble();

        System.out.print("Enter height: ");
        double height = sc.nextDouble();
        // Displaying the Area of triangle 
        double area = 0.5 * base * height;
        System.out.println("Area of triangle is " + area);
    }
}
