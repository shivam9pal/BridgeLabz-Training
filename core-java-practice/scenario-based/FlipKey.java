package week04.scenariobased;

import java.util.Scanner;

class FlipKey {
	
	public static String cleanseAndInvert(String input) {
		//base condition
		if(input.length()<=6 ||
				input.equals(null) ||
				input.startsWith(" ") ||
				input.endsWith(" ") ||
				input.matches(".*\\d.*")) {
			
			return "";
		}
		
		input=input.toLowerCase();
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<input.length();i++) {
			int even=input.charAt(i);
			if(even%2!=0) {
				sb.append(input.charAt(i));
			}
		}
		sb.reverse();
		
		
		for(int i=0;i<sb.length();i++) {
			if(i==0 || i%2==0) {
				sb.setCharAt(i, (char) ((char)sb.charAt(i)-32));
				
			}
		}
		return sb.toString();
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the String to get code : ");
		String input=sc.next();
		String output=cleanseAndInvert(input);
		
		if(output.length()>2) {
			System.out.println(output);
		}else {
			System.out.println("Invalid input :"+input);
		}
		
		
	}
}
