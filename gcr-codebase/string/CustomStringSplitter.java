package week01.string.level2;

import java.util.Arrays;
import java.util.Scanner;

public class CustomStringSplitter {
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
		
		
		// Convert the string into words array 
		public static String[] splitStringIntoWords(String str) {

			String trimStr = str.trim();
			int length = calculateCustomLength(trimStr);

			// Count words properly
			int wordCount = 0;
			boolean isWord = false;

			for (int i = 0; i < length; i++) {
				if (trimStr.charAt(i) != ' ' && !isWord) {
					wordCount++;
					isWord = true;
				} else if (trimStr.charAt(i) == ' ') {
					isWord = false;
				}
			}

			//  Create array
			String[] words = new String[wordCount];
			StringBuilder sb = new StringBuilder();
			int index = 0;

			// Extract words
			for (int i = 0; i < length; i++) {
				if (trimStr.charAt(i) != ' ') {
					sb.append(trimStr.charAt(i));
				} else if (sb.length() > 0) {
					words[index++] = sb.toString();
					sb.setLength(0);
				}
			}

			// Add last word
		    if (sb.length() > 0) {
		        words[index] = sb.toString();
		    }
		
		    return words;
		}

		
		// String words Array using split function
		public static String[] inBuiltSplit(String str) {
			String trimStr=str.trim();
			
			// Gettting String Array Using split method
			String[] arr=new String[calculateCustomLength(trimStr)];
			arr=trimStr.split(" ");
			
			return arr;
		}
		
		// compare both strings
		public static boolean compareStrings(String str) {

		    String[] customArrayOfWords = splitStringIntoWords(str);
		    String[] builtInArrayOfWords = inBuiltSplit(str);
		
		    if (customArrayOfWords.length != builtInArrayOfWords.length) {
		        return false;
		    } else {
		        for (int i = 0; i < customArrayOfWords.length; i++) {
		            if (!customArrayOfWords[i].equals(builtInArrayOfWords[i])) {
		                return false;
		            }
		        }
		    }
		    return true;
		}



	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// Taking user input
		
		String userInput=sc.nextLine();
		sc.close();
		
		
		boolean result=compareStrings(userInput);
		if(result) {
			System.out.println("Both String Arrays Are Equal   =>"+ Arrays.toString(inBuiltSplit(userInput))+" and "+ Arrays.toString(splitStringIntoWords(userInput)));
					
		}else {
			System.out.println("Both String Arrays Are not Equal   =>"+ Arrays.toString(inBuiltSplit(userInput))+" and "+ Arrays.toString(splitStringIntoWords(userInput)));
		}
		
		
	}

}
