package week01.flowControl.level3;

import java.util.Scanner;


public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter weight in kg: ");
        double weight = scanner.nextDouble();
        
        System.out.print("Enter height in cm: ");
        double heightCm = scanner.nextDouble();
        
        // Convert cm to meter
        double heightM = heightCm / 100;
        
        // Calculate BMI using formula BMI 
        double bmi = weight / (heightM * heightM);
        
        // Determine weight status
        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }
        
        // Display results
        System.out.printf("BMI: %.2f kg/m^2\n", bmi);
        System.out.println("Status: " + status);
        
        scanner.close();
    }
}
