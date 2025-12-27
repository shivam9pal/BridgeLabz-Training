package week01.method;

import java.util.Scanner;

public class DistanceAndLineEquation {

    //calculate distance
    public static double findDistance(double x1, double y1,double x2, double y2) {
        double distance = Math.sqrt(
                Math.pow(x2 - x1, 2) +
                Math.pow(y2 - y1, 2)
        );

        return distance;
    }

    // Method to calculate slope (m) and y-intercept (b)
    public static double[] findLineEquation(
            double x1, double y1,
            double x2, double y2) {
        double[] result = new double[2];
        double slope = (y2 - y1) / (x2 - x1);
        double intercept = y1 - slope * x1;

        result[0] = slope;
        result[1] = intercept;

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking input for first point
        System.out.print("Enter x1 and y1: ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        // Taking input for second point
        System.out.print("Enter x2 and y2: ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
       
        double distance = findDistance(x1, y1, x2, y2);

        
        double[] line = findLineEquation(x1, y1, x2, y2);

        // Displaying results
        System.out.println("\nEuclidean Distance between two points: " + distance);
        System.out.println("Equation of Line:");
        System.out.println("y = " + line[0] + "x + " + line[1]);

        scanner.close();
    }
}
