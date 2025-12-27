package week01.method;

import java.util.Scanner;

public class WindChillCalculator {
    // calculate wind chill temperature
    public double calculateWindChill(double temperature, double windSpeed) {
        double windChill = 35.74+ 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);

        return windChill;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter the temperature (in Fahrenheit): ");
        double temperature = sc.nextDouble();
        System.out.print("Enter the wind speed (in miles per hour): ");
        double windSpeed = sc.nextDouble();
        sc.close();

        WindChillCalculator calculator = new WindChillCalculator();
        // Method call
        double result = calculator.calculateWindChill(temperature, windSpeed);
        // Display result
        System.out.printf("The Wind Chill Temperature is: %.2f°F%n", result);
    }
}
