package week01.method;

import java.util.Scanner;

public class StudentScoreCard {

    //random 2-digit PCM marks
    public static int[][] generateMarks(int students) {
        int[][] marks = new int[students][3];

        for (int i = 0; i < students; i++) {
            marks[i][0] = (int) (Math.random() * 90) + 10; 
            marks[i][1] = (int) (Math.random() * 90) + 10; 
            marks[i][2] = (int) (Math.random() * 90) + 10; 
        }

        return marks;
    }

    //calculate total, average, percentage
    public static double[][] calculateResult(int[][] marks) {
        int students = marks.length;
        double[][] result = new double[students][3];
        for (int i = 0; i < students; i++) {

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }

        return result;
    }

    // grade based on percentage
    public static String getGrade(double percentage) {
        if (percentage >= 80)
            return "A";
        else if (percentage >= 70)
            return "B";
        else if (percentage >= 60)
            return "C";
        else if (percentage >= 50)
            return "D";
        else if (percentage >= 40)
            return "E";
        else
            return "R";
    }

    //display scorecard in tabular format
    public static void displayScoreCard(
            int[][] marks, double[][] result) {

        System.out.println("Std\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");

        for (int i = 0; i < marks.length; i++) {

            String grade = getGrade(result[i][2]);

            System.out.println(
                    (i + 1) + "\t" +
                    marks[i][0] + "\t" +
                    marks[i][1] + "\t" +
                    marks[i][2] + "\t" +
                    (int) result[i][0] + "\t" +
                    result[i][1] + "\t" +
                    result[i][2] + "\t" +
                    grade
            );
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = scanner.nextInt();

        int[][] marks = generateMarks(students);
        double[][] result = calculateResult(marks);

        displayScoreCard(marks, result);

        scanner.close();
    }
}
