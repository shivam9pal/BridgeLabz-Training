package week02.scenario;

import java.util.Arrays;
import java.util.Scanner;

public class StudentScores {
	
	static int [] storeScore(int n) {
		String st = inputScore(n, 1);
		System.out.println("Scores: "+st);
		
		return Arrays.stream(st.split(" ")).mapToInt(Integer :: parseInt).toArray();
	}
	
	static String inputScore(int n, int m) {
		Scanner sc = new Scanner(System.in);
		try {
			
			if(n==1) {
				System.out.print("Enter marks of student "+m+": ");
				int score = sc.nextInt();
				sc.nextLine();
				
				if(score>=0 && score<=100) {
					sc.close();
					return score+"";
					
				}else {
					System.out.println("Enter score between 0 and 100.");
					return inputScore(n,m)+"";
				}
				
				
			}
			System.out.print("Enter marks of student "+m+": ");
			int score = sc.nextInt();
			sc.nextLine();
			
			if(score>=0 && score<=100) {
				return score+" "+inputScore(n-1, m+1);
			}else {
				System.out.println("Enter score between 0 and 100.");
				return inputScore(n,m)+"";
			}
			
		}
		catch(Exception e) {
			sc.nextLine();
			System.out.println("Invalid input...");
			return inputScore(n,m)+"";
		}
	
		
	}
	
	static float avg(int[] arr) {
		int sum = 0;
		for(int x:arr) {
			sum+=x;
		}
		return Math.round((sum/arr.length)*100.0f)/100.0f;
	}
	
	static void aboveAvg(int[] arr) {
		float avg = avg(arr);
		for(int x:arr) {
			if (x>avg) {
				System.out.print(x+" ");
			}
		}
		System.out.println();
	}
	
	static void maxAndMin(int[] arr) {
		int max=arr[0], min=arr[0];
		for(int x:arr) {
			if(max<x) {
				max=x;
			}
			if(min>x) {
				min=x;
			}
		}
		System.out.println("Highest Marks: "+max);
		System.out.println("Lowest Marks: "+min);
	}

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of Students : ");
		int n = sc.nextInt();
		int[] stArray = storeScore(n);
		
		System.out.println("Average Score: "+avg(stArray));
		System.out.print("Scores above average score: ");
		aboveAvg(stArray);
		maxAndMin(stArray);
		

		sc.close();
		}
    }


