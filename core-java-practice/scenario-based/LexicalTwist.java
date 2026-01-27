package week04.scenariobased;

import java.util.HashSet;
import java.util.Scanner;

class LexicalTwist {
	
	//check reverse
	public static boolean isWordReversed(String wordOne, String wordTwo) {
		
		StringBuilder sb=new StringBuilder(wordOne);
		String reverse=sb.reverse().toString().toLowerCase();
		String word=wordTwo.toLowerCase();
		
		
		return word.equals(reverse);
	}
	
	//replace all vowels
	public static String replaceVowel(String str) {
		//str to lower case
		str=str.toLowerCase();
		StringBuilder sb=new StringBuilder(str);
		for(int i=0;i<sb.length();i++) {
			if(sb.charAt(i)=='a' ||sb.charAt(i)=='e'  ||sb.charAt(i)=='i'  ||sb.charAt(i)=='o'  ||sb.charAt(i)=='u') {
				sb.setCharAt(i, '@');
			}
		}
		
		return sb.toString();
	}
	
	//combine word
	public static String combineWord(String wordOne, String wordTwo) {
		
		//add word
		StringBuilder sBuilder=new StringBuilder(wordOne);
		sBuilder.append(wordTwo);
		
		//to upper case 
		return sBuilder.toString().toUpperCase();
	}
	
	//count vowels and consonant	
	public static void countAndPrint(String str) {
		int vowel=0;
		int consonant=0;
		HashSet<Character> vows=new HashSet<>();
		HashSet<Character> cons=new HashSet<>();
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if (Character.isLetter(ch)) {
		    if ("AEIOU".indexOf(ch) != -1) {
		        vowel++;
		        if (vows.size() < 2) vows.add(ch);
		    } else {
		        consonant++;
		        if (cons.size() < 2) cons.add(ch);
		    	}
			}
		}
		
		if(vowel>consonant) {
			for(Character s:vows) {
				System.out.print(Character.toUpperCase(s));
			}
		}else if(vowel<consonant) {
			for(Character s:cons) {
				System.out.print(Character.toUpperCase(s));
			}
		}else {
			System.out.println("Vowels and consonants are equal");
		}		
	}
	
	
	//main method
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter the String to check :");
		String wordOne=scanner.next();
		System.out.print("\nEnter the Next String to check :");
		String wordTwo=scanner.next();
		
		
		//check the reverse or not 
		
		boolean check=isWordReversed(wordOne,wordTwo);
		
		//now 
		if(check) {
			String reversed = new StringBuilder(wordOne).reverse().toString();
		    String resultString = replaceVowel(reversed);

		   
		    System.out.println(resultString);
		}else {
			//combine word
			String combineWord=combineWord(wordOne, wordTwo);
			
			countAndPrint(combineWord);
		}
		
		
		
	}
}




















