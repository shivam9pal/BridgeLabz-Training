package week04.gcrcodebase.regex;

import java.util.Scanner;

class ValidateNumberPlate {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String validate="^[A-Z]{2}\\d{4}$";
		System.out.print("Enter the Vechile Number to Validate :");
		String numebrPlate=scanner.nextLine();
		
		if(numebrPlate.matches(validate)) {
			System.out.println("Valid Number Plate ");
			}else {
		System.out.println("Invalid Number plate");
			}
		
	}
}
