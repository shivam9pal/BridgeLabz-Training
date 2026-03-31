package week01.string.level2;

import java.util.Scanner;

public class CountVowelConsonantTable {
	
	//Returning the Vowel,Consonant and Not a Word 
		public static String isVowel(char chr) {
			
			int chrCase=(int)chr;
			
			if(chrCase >= 65 && chrCase<=90) {
				chrCase+=32;
			}
			char lowerCase=(char)chrCase;
			// Checking the Vowel or Consonant
			if(lowerCase=='a' || lowerCase=='e' || lowerCase=='i' || lowerCase=='o' || lowerCase=='u') {
				return new String("Vowel");
			}else if(lowerCase >= 'a' && lowerCase <= 'z'){
				return new String("Consonant");
			}else {
				return new String("Not a Letter");
			}
		}
		
		// Create 2D array of character and its type
	    public static String[][] findVowelsAndConsonants(String str) {

	        int length = str.length();
	        String[][] result = new String[length][2];

	        for (int i = 0; i < length; i++) {
	            char ch = str.charAt(i);
	            result[i][0] = String.valueOf(ch);
	            result[i][1] = isVowel(ch);
	        }

	        return result;
	    }
	    // Displaying the Result in tabular form 
	    public static void displayTable(String[][] data) {

	        System.out.println("Character\tType");

	        for (int i = 0; i < data.length; i++) {
	            System.out.println(data[i][0] + "\t\t" + data[i][1]);
	        }
	    }

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Taking user input as String 
		System.out.print("Enter the String :");
		String userInput=sc.nextLine();
		//Getting User 
		String[][] result=findVowelsAndConsonants(userInput);
		displayTable(result);

	}

}
