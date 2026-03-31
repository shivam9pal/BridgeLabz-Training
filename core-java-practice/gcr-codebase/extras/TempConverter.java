package week01.extrasBuiltInFunction;

import java.util.Scanner;

public class TempConverter {
    //Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
    	double temp=(celsius * 9 / 5) + 32;
        return temp;
    }

    //Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
    	double temp=(fahrenheit - 32) * 5 / 9;
        return temp;
    }
    //user input
    public static double userInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature value: ");
        return sc.nextDouble();
    }
    //display result
    public static void displayResult(double input, double result, String type) {
        if (type.equals("C")) {
            System.out.println(input + "°C = " + result + "°F");
        } else {
            System.out.println(input + "°F = " + result + "°C");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Displaying Option
        System.out.println(" Temperature Converter 🌡");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Choose option: ");
        int choice = sc.nextInt();
        
        double temperature = userInput();
        double convertedValue;
        //On the basis of user choice 
        if (choice == 1) {
            convertedValue = celsiusToFahrenheit(temperature);
            displayResult(temperature, convertedValue, "C");
        } else if (choice == 2) {
            convertedValue = fahrenheitToCelsius(temperature);
            displayResult(temperature, convertedValue, "F");
        } else {
            System.out.println("Invalid choice!");
        }
    }
}
