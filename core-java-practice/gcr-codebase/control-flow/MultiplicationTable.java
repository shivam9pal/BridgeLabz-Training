package week01.flowControl.level2;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking user input        
        System.out.println(" Multiplication Table (6-9) ");
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        //Printing Using the for loop
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
        
        scanner.close();
    }
}
