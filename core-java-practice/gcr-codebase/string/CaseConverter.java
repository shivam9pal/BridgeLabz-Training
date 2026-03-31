package week01.string.level1;

import java.util.*;
public class CaseConverter {
	
	//Converts a given string to uppercase using charAt() 
	public static String convertToUpperCase(String input) {
        StringBuilder result = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar >= 'a' && currentChar <= 'z') {
                result.append((char) (currentChar - 32));
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }
	
	
	// Compares two strings character by character using charAt()
	public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        // Compare each character
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false; 
            }
        }

        return true; 
    }
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a line of text:");
        String userInput = sc.nextLine();
        
        //Use the built-in toUpperCase() method
        String builtInUppercase = userInput.toUpperCase();
        
        //Use the user-defined method to convert to uppercase
        String customUppercase = convertToUpperCase(userInput);
        
        //Compare the two strings 
        boolean areEqual = compareStrings(builtInUppercase, customUppercase);
	}

}