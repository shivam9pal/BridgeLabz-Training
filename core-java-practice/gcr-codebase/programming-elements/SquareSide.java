package week01.programmingElements;

import java.util.Scanner;

public class SquareSide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter perimeter: ");
        double perimeter = sc.nextDouble();
        // Displaying the Side and Perimeter
        double side = perimeter / 4;
        System.out.println("The length of the side is " + side +
                " whose perimeter is " + perimeter);
    }
}

