package week01.flowControl.level2;

import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking user input for Bonus and salary
        System.out.println(" Employee Bonus Calculator ");
        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter years of service: ");
        int yearsOfService = scanner.nextInt();
        
        double bonus = 0;
        // Displaying Salary on the basis of year of service 
        if (yearsOfService > 5) {
            bonus = salary * 0.05;
            System.out.println("Bonus Amount: " + bonus);
        } else {
            System.out.println("No bonus. Years of service must be more than 5.");
        }
        
        scanner.close();
    }
}
