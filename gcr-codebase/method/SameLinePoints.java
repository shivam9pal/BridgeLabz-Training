package week01.method;

import java.util.Scanner;

public class SameLinePoints {

    //check collinearity 
    public static boolean isCollinearUsingSlope(
            int x1, int y1,
            int x2, int y2,
            int x3, int y3) {

        return (y2 - y1) * (x3 - x2) ==(y3 - y2) * (x2 - x1);
    }

    //collinearity using area of triangle formula
    public static boolean isCollinearUsingArea(
            int x1, int y1,
            int x2, int y2,
            int x3, int y3) {

        double area = 0.5 * (
                x1 * (y2 - y3) +
                x2 * (y3 - y1) +
                x3 * (y1 - y2)
        );

        return area == 0;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Taking user input for three points
        System.out.println("Enter coordinates of Point A (x1 y1): ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        System.out.println("Enter coordinates of Point B (x2 y2): ");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        System.out.println("Enter coordinates of Point C (x3 y3): ");
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();

        boolean slopeResult = isCollinearUsingSlope(x1, y1, x2, y2, x3, y3);

        boolean areaResult = isCollinearUsingArea(x1, y1, x2, y2, x3, y3);

        // Displaying results
        System.out.println("\nUsing Slope Formula:");
        if (slopeResult) {
            System.out.println("Points are Collinear");
        } else {
            System.out.println("Points are NOT Collinear");
        }

        System.out.println("\nUsing Area of Triangle Formula:");
        if (areaResult) {
            System.out.println("Points are Collinear");
        } else {
            System.out.println("Points are NOT Collinear");
        }

        scanner.close();
    }
}
