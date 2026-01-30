package week04.gcrcodebase.regex;

import java.util.Scanner;

class UsernameValidate {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String validUsername="^[A-Za-z][A-Za-z0-9]{4,14}$";
		
		System.out.print("Enter the Username:");
		String userName=scanner.nextLine();
		
		if(userName.matches(validUsername)) {
			System.out.println("Username is Valid...");
		}else {
			System.out.println("Invalid username...");
		}
		
	}
}
