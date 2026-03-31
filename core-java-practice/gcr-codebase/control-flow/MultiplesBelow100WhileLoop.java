package week01.flowControl.level2;

import java.util.Scanner;

public class MultiplesBelow100WhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking user input   
        System.out.println(" Multiples Below 100 (While Loop) ");
        System.out.print("Enter a positive integer less than 100: ");
        int number = scanner.nextInt();
        
        if (number <= 0 || number >= 100) {
            System.out.println("Please enter a positive integer less than 100.");
            scanner.close();
            return;
        }
        //Dispalying the Multipile beo=low 100 Using the while loop
        System.out.println("Multiples of " + number + " below 100:");
        int counter = 100;
        while (counter >= 1) {
            if (counter % number == 0) {
                System.out.println(counter);
            }
            counter--;
        }
        
        scanner.close();
    }
}
