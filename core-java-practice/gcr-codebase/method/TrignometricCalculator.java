package week01.method;

import java.util.Scanner;

public class TrignometricCalculator {

    //calculate sine, cosine, and tangent
    public static double[] calculateTrigonometricFunctions(double angleInDegrees) {
        // Convert degrees to radians
        double angleInRadians = Math.toRadians(angleInDegrees);
        double sine = Math.sin(angleInRadians);
        double cosine = Math.cos(angleInRadians);
        double tangent = Math.tan(angleInRadians);
        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();
        sc.close();
        // Method call
        double[] result = calculateTrigonometricFunctions(angle);
      // Display result
        System.out.printf("Sine of %.2f° = %.4f%n", angle, result[0]);
        System.out.printf("Cosine of %.2f° = %.4f%n", angle, result[1]);
        System.out.printf("Tangent of %.2f° = %.4f%n", angle, result[2]);
    }
}
