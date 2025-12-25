package week01.string.level2;

import java.util.Scanner;

public class CalculateGrade {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of Students : ");
		int n = sc.nextInt();
		int[][] score = generateScores(n);
		double[][] result = calculations(score);
		String[][] gradeArray = gradeCal(result);
		
		for(int i=0;i<n;i++) {
			for(int j=0; j<7; j++) {
				System.out.print(gradeArray[i][j]+"  ");
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	//method for generating the scores of different subjects
	static int[][] generateScores(int n){
		int[][] score = new int[n][3];
		for (int i=0; i<n;i++) {
			score[i][0]= (int)((Math.random()*90)+10);
			score[i][1]= (int)((Math.random()*90)+10);
			score[i][2]= (int)((Math.random()*90)+10);
		}
		return score;
	}
	
	//method to calculate total, average, percentage
	static double[][] calculations(int[][] arr){
		double[][] result = new double[arr.length][6];
		for(int i=0; i<arr.length; i++) {
			result[i][0] = arr[i][0];
			result[i][1] = arr[i][1];
			result[i][2] = arr[i][2];
			result[i][3] = arr[i][0] + arr[i][1] + arr[i][2];
			result[i][4] = Math.round((result[i][3]/3)*100.0)/100.0;
			result[i][5] = Math.round(((result[i][3]*100)/300)*100.0)/100.0;
		}
		return result;
	}
	
	// method to find the grade based on percentage
	static String[][] gradeCal(double[][] arr){
		String[][] grade = new String[arr.length][arr[0].length+1];
		for(int i=0; i<grade.length;i++) {
			for(int j=0; j<arr[0].length; j++) {
				grade[i][j] = String.valueOf(arr[i][j]);
			}
			if(arr[i][5]>=80) {
				grade[i][6] = String.valueOf('A');
			}
			else if((arr[i][5]>=70)&&(arr[i][5]<=79)) {
				grade[i][6] = String.valueOf('B');
			}
			else if((arr[i][5]>=60)&&(arr[i][5]<=69)) {
				grade[i][6] = String.valueOf('C');
			}
			else if((arr[i][5]>=50)&&(arr[i][5]<=59)) {
				grade[i][6] = String.valueOf('D');
			}
			else if((arr[i][5]>=40)&&(arr[i][5]<=49)) {
				grade[i][6] = String.valueOf('E');
			}else {
				grade[i][6] = String.valueOf('R');
			}
		}
		return grade;
	}
}
