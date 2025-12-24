package week01.arrays.level1;

import java.util.Scanner;

public class MeanHeightCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create array for 11 players
        double[] heights = new double[11];
        double sum = 0.0;
        
        // Get input for heights
        System.out.println("Enter the height of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
            sum += heights[i];
        }
        
        // Calculate mean
        double mean = sum / 11;
        
        // Display the mean height
        System.out.println("\nSum of all heights: " + sum);
        System.out.println("Mean height of the football team: " + mean);
        
        scanner.close();
    }
}
