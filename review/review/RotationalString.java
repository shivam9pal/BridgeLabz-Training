package week02.gcrCodebase.classObject.review;

import java.util.Scanner;
public class RotationalString {
	//check length
	public static boolean isEqual(String strOne,String strTwo) {
		if(strOne.length()==strTwo.length()) {
			return true;
		}
		return false;
		
	}
	
	
	
	public static boolean isRotated(String strOne,String strTwo) {
		String inputOne=strOne.toLowerCase().trim();
		String inputTwo=strTwo.toLowerCase().trim();
		boolean isEqual=isEqual(inputOne,inputTwo);
		
		if(!isEqual) {
			return false;
		}else {
			
			String concat=inputOne.concat(inputOne);
			if(concat.contains(inputTwo)) {
				return true;
				}
			}
		return false;
		
	}
	//checking rotation
	public static boolean isRotational(String strOne,String strTwo) {
		String inputOne=strOne.toLowerCase().trim();
		String inputTwo=strTwo.toLowerCase().trim();
		boolean isEqual=isEqual(inputOne,inputTwo);
		if(!isEqual) {
			return false;
		}else {
			StringBuilder sb=new StringBuilder(inputTwo);
			sb.reverse();
			if(sb.toString().equals(inputOne)) {
				return true;
				}
			}
		return false;
		
		}
		
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Taking String 1
		System.out.print("Enter the first String :");
		String inputOne=sc.nextLine();
		System.out.print("\nEnter the Second String :");
		String inputTwo=sc.nextLine();
		sc.close();
		
		boolean result=isRotated(inputOne,inputTwo);
		if(result) {
			System.out.println("Yes the Given String is Rotational  ....");
		}else {
			System.out.println("Yes the Given String is not Rotational  ....");
		}
		
		
		
		
	}
}
