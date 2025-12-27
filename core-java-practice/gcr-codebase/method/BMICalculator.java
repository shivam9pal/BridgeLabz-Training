package week01.method;

import java.util.Scanner;

public class BMICalculator {

    //calculate BMI 
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {

            double weight = data[i][0];      
            double heightCm = data[i][1];    
            double heightMeter = heightCm / 100;

            double bmi = weight / (heightMeter * heightMeter);
            data[i][2] = bmi;
        }
    }

    //BMI status for all persons
    public static String[] determineBMIStatus(double[][] data) {

        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];

            if (bmi <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                status[i] = "Normal";
            } else if (bmi >= 25.0 && bmi <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double[][] personData = new double[10][3];
        // Taking user input
        for (int i = 0; i < personData.length; i++) {
            System.out.println("Enter details for Person " + (i + 1));
            System.out.print("Weight kg: ");
            personData[i][0] = scanner.nextDouble();
            System.out.print("Height cm: ");
            personData[i][1] = scanner.nextDouble();
        }
        
        calculateBMI(personData);
        // Get BMI status
        String[] bmiStatus = determineBMIStatus(personData);

        // Display results
        System.out.println("--- BMI REPORT ---");
        System.out.printf("%-10s %-12s %-10s %-15s%n", "Weight", "Height(cm)", "BMI", "Status");
        for (int i = 0; i < personData.length; i++) {
            System.out.printf(
                    "%-10.2f %-12.2f %-10.2f %-15s%n",
                    personData[i][0],
                    personData[i][1],
                    personData[i][2],
                    bmiStatus[i]
            );
        }

        scanner.close();
    }
}
