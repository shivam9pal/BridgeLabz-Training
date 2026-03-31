package week01.method;

import java.util.*;

public class StudentVoteChecker {

    //whether a student can vote
    public boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }
        if (age >= 18) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentVoteChecker checker = new StudentVoteChecker();
        int[] ages = new int[10];
        System.out.println("Enter the age of 10 students:");
        // Loop to take input and check voting eligibility OR Math.random()
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
//            ages[i] = scanner.nextInt();
            ages[i] = (int) (Math.random()*(91)+0);

            boolean canVote = checker.canStudentVote(ages[i]);

            if (canVote) {
                System.out.println("Student " + (i + 1) + " is eligible to vote.");
            } else {
                System.out.println("Student " + (i + 1) + " is NOT eligible to vote.");
            }
        }

        scanner.close();
    }
}
