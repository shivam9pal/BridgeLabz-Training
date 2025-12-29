package week01.extrasBuiltInFunction;

import java.util.Scanner;

public class PrimeNumberChecker {
	//Checking Is number is Prime
	public static boolean isPrime(int num) {
		if(num<0) {
			return false;
		}else if(num==1) {
			return false;
		}
		for(int i=2;i<Math.sqrt(num);i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
	
	//Take user input
	public static int userInput() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number to check Prime Or Non-Prime :");
		int num=sc.nextInt();
		return num;
	}
	//Take user input
	public static void displayResult(boolean result) {
		if(result) {
			System.out.println("The Given Number is PRIME ");
		}else {
			System.out.println("The Given Number is Non-PRIME :");
		}		
	}				
	
	
	public static void main(String[] args) {
		int userInput=userInput();
		boolean isPrime=isPrime(userInput);
		displayResult(isPrime);
	}
}
