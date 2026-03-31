package week01.string.level2;


import java.util.Arrays;
import java.util.Scanner;
public class ShortestLongestString {
	
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
	
	//Splitting String into words and returning words array
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
		String[] strArray=splitStringIntoWords(str);
		String[][] result=new String[strArray.length][2];
		for(int i=0;i<strArray.length;i++) {
			String wordLength=String.valueOf(strArray[i].length());
			result[i][0]=strArray[i];
			result[i][1]=wordLength;
		}
		return result;
		
	}
	
	//Finding Longest and shortest String 
	public static int[] longestShortest(String[][] strArray) {
		
		int longest=Integer.MIN_VALUE;
		int shortest=Integer.MAX_VALUE;
		
		for(int i=0;i<strArray.length;i++) {
			int length=Integer.parseInt(strArray[i][1]);
			
			//checking the length
			if(length<shortest) {
				shortest=length;
			}
			if(length>longest) {
				longest=length;
			}
		}
		return new int[] {longest,shortest};
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// Taking user input
		String userInput=sc.nextLine();
		
		//Getting array and shortest and longest
		String[][] arrayOfString=wordsWithLength(userInput);
		int[] shortLong=longestShortest(arrayOfString);
		
		int longStr =shortLong[0];
		int shortStr=shortLong[1];
		//Displaying the Shortest and Longest
		System.out.println("The Longest length of String is :"+ longStr+"  &  "+"The Shortest length of String is :"+shortStr);
		
		
		sc.close();
	}
}
