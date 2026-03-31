package week01.string.level2;


import java.util.Scanner;
public class CountVowelConsonant {
	
	//Returning the IsVowel 
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
	
	// Displaying result method 
	public static void displayVowel(String str) {
		char[] strArray=str.toCharArray();
		int vowelCount=0;
		int consonantCount=0;
		int notAWord=0;
		for(int i=0;i<strArray.length;i++) {
			String result=isVowel(strArray[i]);
			if(result.equals("Vowel")) {
				vowelCount++;
			}else if(result.equals("Consonant")) {
				consonantCount++;
			}else {
				notAWord++;
			}
		}
		
		//now prtinting the Result
		System.out.printf("The count of Vowel is :%d and the count of Consonant is :%d\n "
				+ "and the count of other than alphabets :%d",vowelCount,consonantCount,notAWord);
		
	}
	
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Taking user input 
		String userInput=sc.nextLine();
		// This Fuction will count and display the result
		displayVowel(userInput);
		sc.close();
	}
}
