package week04.gcrcodebase.regex;

import java.util.Scanner;

class ValodateHexCode {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String hexCode="^#[0-9A-Fa-f]{6}$";
		System.out.println("Enter the Hexcode to validate :");
		String input=scanner.nextLine();
		if(input.matches(hexCode)) {
			System.out.println("Valid  ");
			}else {
		System.out.println("Invalid");
			}
	}
}	
