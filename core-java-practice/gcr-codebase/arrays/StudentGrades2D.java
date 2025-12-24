package week01.arrays.level2;

import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // a. All steps are same as problem 8 except marks are stored in 2D array
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        
        // b. Use 2D array to store marks (3 subjects per student)
        // marks[i][0] = Physics, marks[i][1] = Chemistry, marks[i][2] = Maths
        double[][] marks = new double[numStudents][3];
        double[] percentages = new double[numStudents];
        String[] grades = new String[numStudents];
        
        // Take input for marks
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            
            String[] subjects = {"Physics", "Chemistry", "Maths"};
            for (int j = 0; j < 3; j++) {
                do {
                    System.out.print("Enter " + subjects[j] + " marks: ");
                    marks[i][j] = scanner.nextDouble();
                    if (marks[i][j] < 0) {
                        System.out.println("Please enter a positive value!");
                    }
                } while (marks[i][j] < 0);
            }
        }
        
        // Calculate percentage and grade
        for (int i = 0; i < numStudents; i++) {
            double totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (totalMarks / 300) * 100;
            
            // Determine grade
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
        
        // Display results
        System.out.println("\n===== Student Grade Report (2D Array) =====");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        System.out.println("-------\t-------\t---------\t-----\t----------\t-----");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t\t%.2f\t%.2f%%\t\t%s\n", 
                (i + 1), marks[i][0], marks[i][1], marks[i][2], 
                percentages[i], grades[i]);
        }
        
        scanner.close();
    }
}
