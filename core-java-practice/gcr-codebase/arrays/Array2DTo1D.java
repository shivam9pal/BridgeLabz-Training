package week01.arrays.level1;

import java.util.Scanner;

public class Array2DTo1D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input for rows and columns
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = scanner.nextInt();
        
        // Create 2D array (Matrix)
        int[][] matrix = new int[rows][columns];
        
        // Take user input for 2D array
        System.out.println("Enter elements for " + rows + "x" + columns + " matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        // Display 2D array
        System.out.println("2D Array (Matrix):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // Create 1D array
        int[] array = new int[rows * columns];
        int index = 0;
        
        // Copy elements from 2D to 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index] = matrix[i][j];
                index++;
            }
        }
        
        // Display 1D array
        System.out.println("\n1D Array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        
        
    }
}
