package week01.arrays.level2;

import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        final int NUM_EMPLOYEES = 10;
        
        // Define arrays to save salary and years of service
        double[] salaries = new double[NUM_EMPLOYEES];
        double[] yearsOfService = new double[NUM_EMPLOYEES];
        
        double[] bonuses = new double[NUM_EMPLOYEES];
        double[] newSalaries = new double[NUM_EMPLOYEES];
        
        // Variables to save totals
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        
        // Take input from user
        System.out.println("Enter details for 10 employees:");
        for (int i = 0; i < NUM_EMPLOYEES; i++) {
            System.out.println("\nEmployee " + (i + 1) + ":");
            
            // Get valid salary
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter salary: ");
                salaries[i] = scanner.nextDouble();
                if (salaries[i] <= 0) {
                    System.out.println("Invalid salary! Please enter again.");
                    i--;
                     // Decrement counter to re-enter this employee
                    break;
                } else {
                    validInput = true;
                }
            }
            
            if (!validInput) continue;
            
            // Get valid years of service
            validInput = false;
            while (!validInput) {
                System.out.print("Enter years of service: ");
                yearsOfService[i] = scanner.nextDouble();
                if (yearsOfService[i] < 0) {
                    System.out.println("Invalid years of service! Please enter again.");
                    i--; // Decrement counter to re-enter this employee
                    break;
                } else {
                    validInput = true;
                }
            }
        }
        
        // Calculate bonus based on years of service
        for (int i = 0; i < NUM_EMPLOYEES; i++) {
            if (yearsOfService[i] > 5) {
                bonuses[i] = salaries[i] * 0.05; // 5% bonus
            } else {
                bonuses[i] = salaries[i] * 0.02; // 2% bonus
            }
            
            // Calculate new salary
            newSalaries[i] = salaries[i] + bonuses[i];
            
            // Add to totals
            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }
        
        // Print results
        System.out.println(" Zara Company - Employee Bonus Report ");
        System.out.println("Emp#\tOld Salary\tYears\tBonus\t\tNew Salary");
        for (int i = 0; i < NUM_EMPLOYEES; i++) {
            System.out.printf("%d\t%.2f\t%.1f\t%.2f\t\t%.2f\n", 
                (i + 1), salaries[i], yearsOfService[i], bonuses[i], newSalaries[i]);
        }
        
        System.out.println(" Summary ");
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total Bonus Payout: %.2f\n", totalBonus);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
        
        scanner.close();
    }
}
