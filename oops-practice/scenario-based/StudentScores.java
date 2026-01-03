package week02.scenario;

import java.util.Scanner;

public class StudentScores {
	public static void analyzeTemperature(float[][] temp) {

	    int hottestDay = 0;
	    int coldestDay = 0;
	    float maxTemp = temp[0][0];
	    float minTemp = temp[0][0];

	    for (int i = 0; i < temp.length; i++) {
	        float sum = 0;
	        for (int j = 0; j < temp[i].length; j++) {

	            sum += temp[i][j];

	            if (temp[i][j] > maxTemp) {
	                maxTemp = temp[i][j];
	                hottestDay = i;
	            }
	            if (temp[i][j] < minTemp) {
	                minTemp = temp[i][j];
	                coldestDay = i;
	            }
	        }
	        float average = sum / temp[i].length;
	        System.out.println("Average temperature of day " + (i + 1)
	                + " = " + average);
	    }
	    System.out.println("Hottest day: Day " + (hottestDay + 1));
	    System.out.println("Coldest day: Day " + (coldestDay + 1));
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] scores = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter score of student " + (i + 1) + ": ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter numbers only.");
                return;
            }
            int score = sc.nextInt();
            if (score < 0) {
                System.out.println("Score cannot be negative.");
                return;
            }
            scores[i] = score;
            sum += score;
        }

        double average = (double) sum / n;
        analyzeTemperature();
        sc.close();
    }
}

