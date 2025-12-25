package week01.string.level2;

import java.util.*;

public class WordsLengthTwoArray {
	
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
			
			//Return the Two-D array With Words and its Length
			public static String[][] wordsWithLength(String str){
				//Converting String into Array\
				String[] strArray=splitStringIntoWords(str);
				// Creating two-D Array
				String[][] result=new String[strArray.length][2];
				for(int i=0;i<strArray.length;i++) {
					// getting the length of Words in String
					String wordLength=String.valueOf(strArray[i].length());
					result[i][0]=strArray[i];
					result[i][1]=wordLength;
				}
				return result;
				
			}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//taking user input
		System.out.print("Enter the String :");
		String userInput=sc.nextLine();
		String[][] wordsLengthArray=wordsWithLength(userInput);
		for (int i = 0; i < wordsLengthArray.length; i++) {
		    String word = wordsLengthArray[i][0];
		    int length = Integer.parseInt(wordsLengthArray[i][1]);
		    System.out.println(word + " :" + length);
		}
		
		

	}

}
