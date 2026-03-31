package week01.arrays.level2;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take input for number of persons
        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();
        
        // Create arrays to store
        double[] weights = new double[numPersons];
        double[] heights = new double[numPersons];
        double[] bmis = new double[numPersons];
        String[] statuses = new String[numPersons];
        
        // Take input for weight and height of the persons
        for (int i = 0; i < numPersons; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.print("Enter weight (kg): ");
            weights[i] = scanner.nextDouble();
            System.out.print("Enter height (m): ");
            heights[i] = scanner.nextDouble();
        }
        
        // Calculate BMI and determine weight status
        for (int i = 0; i < numPersons; i++) {
            bmis[i] = weights[i] / (heights[i] * heights[i]);
            
            // Use table to determine weight status
            if (bmis[i] <= 18.4) {
                statuses[i] = "Underweight";
            } else if (bmis[i] >= 18.5 && bmis[i] <= 24.9) {
                statuses[i] = "Normal";
            } else if (bmis[i] >= 25.0 && bmis[i] <= 39.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        
        // Display height, weight, BMI, and weight status of each person
        
        System.out.println("Person\tHeight(m)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t\t%s\n", 
                (i + 1), heights[i], weights[i], bmis[i], statuses[i]);
        }
        
        scanner.close();
    }
}
