package week01.string.level2;

import java.util.Scanner;
public class CustomStringLength {
	//Custom function to check the length by using CharAt() 
	public static int calculateCustomLength(String str) {
		int count=0;
		try {
			while(true) {
				str.charAt(count);
				count++;
			}
		}catch(IndexOutOfBoundsException e) {
			return count;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// Raking User inout String
		System.out.print("Enter the String to check Length");
		String userInput=sc.nextLine();
		
		
		int customLength=calculateCustomLength(userInput);
		
		int inbuiltLength=userInput.length();
		
		System.out.println("Length By the Custom charAt: "+ customLength);
		System.out.println("Length By the Length(): "+);
		
		
		
		
	}
}
