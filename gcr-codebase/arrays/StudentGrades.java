package week01.arrays.level2;

import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // a. Take input for number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        
        // b. Create arrays to store marks, percentages, and grades
        double[] physicsMarks = new double[numStudents];
        double[] chemistryMarks = new double[numStudents];
        double[] mathsMarks = new double[numStudents];
        double[] percentages = new double[numStudents];
        String[] grades = new String[numStudents];
        
        // c. Take input for marks in physics, chemistry, and maths
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            
            // Get valid physics marks
            do {
                System.out.print("Enter Physics marks: ");
                physicsMarks[i] = scanner.nextDouble();
                if (physicsMarks[i] < 0) {
                    System.out.println("Please enter a positive value!");
                }
            } while (physicsMarks[i] < 0);
            
            // Get valid chemistry marks
            do {
                System.out.print("Enter Chemistry marks: ");
                chemistryMarks[i] = scanner.nextDouble();
                if (chemistryMarks[i] < 0) {
                    System.out.println("Please enter a positive value!");
                }
            } while (chemistryMarks[i] < 0);
            
            // Get valid maths marks
            do {
                System.out.print("Enter Maths marks: ");
                mathsMarks[i] = scanner.nextDouble();
                if (mathsMarks[i] < 0) {
                    System.out.println("Please enter a positive value!");
                }
            } while (mathsMarks[i] < 0);
        }
        
        // d. Calculate percentage and grade for each student
        for (int i = 0; i < numStudents; i++) {
            double totalMarks = physicsMarks[i] + chemistryMarks[i] + mathsMarks[i];
            percentages[i] = (totalMarks / 300) * 100;
            
            // Determine grade based on percentage
            if (percentages[i] >= 80) {
                grades[i] = "A (Level 4, above agency-normalized standards)";
            } else if (percentages[i] >= 70) {
                grades[i] = "B (Level 3, at agency-normalized standards)";
            } else if (percentages[i] >= 60) {
                grades[i] = "C (Level 2, below but approaching agency-normalized standards)";
            } else if (percentages[i] >= 50) {
                grades[i] = "D (Level 1, well below agency-normalized standards)";
            } else if (percentages[i] >= 40) {
                grades[i] = "E (Level -1, very far below agency-normalized standards)";
            } else {
                grades[i] = "R (Remedial standards)";
            }
        }
        
        // e. Display results
        System.out.println("\n===== Student Grade Report =====");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        System.out.println("-------\t-------\t---------\t-----\t----------\t-----");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t\t%.2f\t%.2f%%\t\t%s\n", 
                (i + 1), physicsMarks[i], chemistryMarks[i], mathsMarks[i], 
                percentages[i], grades[i]);
        }
        
        scanner.close();
    }
}
