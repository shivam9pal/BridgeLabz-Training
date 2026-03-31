package week01.string.level1;

import java.util.Scanner;

public class CompareString {

	public static boolean compareTwoString(String input1, String input2) {
		if (input1.length() != input2.length()) {
			return false;
		}

		// Iterate through characters.
		for (int i = 0; i < input1.length(); i++) {
			if (input1.charAt(i) != input2.charAt(i)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Strings to Compare !");

		// Taking input for Both Strings
		String input1 = sc.next();
		String input2 = sc.next();

		boolean builtInResult = input1.equals(input2);
		if(builtInResult) {
			System.out.println("Same String ! response by Equals()");
		}else {
			System.out.println("Not Same String ! response by Equals()");
		}
		
		boolean customResult = compareTwoString(input1, input2);
		
		if(customResult){
			System.out.println("Same String ! response by indexing charAt()");
		}else{
			System.out.println("Not Same String ! response by indexing charAt()");
		}
		
		if (builtInResult == customResult) {
			System.out.println("Result Are Same !");
		} else {
			System.out.println("Result Are Not Same !");
		}
        
        sc.close();
	}
}
