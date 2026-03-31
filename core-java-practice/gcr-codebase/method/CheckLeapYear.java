package week01.method;

import java.util.Scanner;
public class CheckLeapYear {
	
	public static boolean isLeapYear(int year) {
		
		//checking the leap year condition
		if(year%4==0 && year%100 !=0 || year%400 == 0) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Taking user input 
		System.out.print("Enter the year to check :");
		int year=sc.nextInt();
		if(year<=1582) {
			System.out.println(" \n Invalid year as per Gregarion Calender");
			return;
		}
		boolean result=isLeapYear(year);
		//Displaying the result
		if(result) {
			System.out.printf("The given year is Leap Year %d",year);
		}else {
			System.out.printf("The given year is NOT a Leap Year %d",year);
		}
		
	}
	
}
