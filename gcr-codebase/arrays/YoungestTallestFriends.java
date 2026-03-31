package week01.arrays.level2;

import java.util.Scanner;

public class YoungestTallestFriends {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Arrays to store age and height for 3 friends
        int[] ages = new int[3];
        double[] heights = new double[3];
        String[] names = {"Amar", "Akbar", "Anthony"};
        
        // Take user input for age and height
        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter details for " + names[i] + ":");
            System.out.print("Enter age: ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter height (cm): ");
            heights[i] = scanner.nextDouble();
        }
        
        // Find youngest friend
        int youngestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        
        // Find tallest friend
        int tallestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        
        // Display results
        System.out.println("\n===== Results =====");
        System.out.println("Youngest friend: " + names[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest friend: " + names[tallestIndex] + " (Height: " + heights[tallestIndex] + " cm)");
        
        scanner.close();
    }
}
