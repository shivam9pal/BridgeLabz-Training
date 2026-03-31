package week01.flowControl.level3;

import java.util.Scanner;


public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter marks for 3 subjects:");
        System.out.print("Physics: ");
        double physics = scanner.nextDouble();
        
        System.out.print("Chemistry: ");
        double chemistry = scanner.nextDouble();
        
        System.out.print("Maths: ");
        double maths = scanner.nextDouble();
        
        // Calculate average percentage
        double average = (physics + chemistry + maths) / 3;
        
        // Determine grade and remarks
        String grade;
        String remarks;
        
        if (average >= 80) {
            grade = "A";
            remarks = "(Level 4, above agency-normalized standards)";
        } else if (average >= 70) {
            grade = "B";
            remarks = "(Level 3, at agency-normalized standards)";
        } else if (average >= 60) {
            grade = "C";
            remarks = "(Level 2, below, but approaching agency-normalized standards)";
        } else if (average >= 50) {
            grade = "D";
            remarks = "(Level 1, well below agency-normalized standards)";
        } else if (average >= 40) {
            grade = "F";
            remarks = "(Level 1-, too below agency-normalized standards)";
        } else {
            grade = "R";
            remarks = "(Remedial instruction)";
        }
        
        // Display results
        System.out.println("\n========== Results ==========");
        System.out.printf("Average Mark: %.2f%%\n", average);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
        
        scanner.close();
    }
}
