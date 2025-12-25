package week01.string.level2;

import java.util.Scanner;

public class RemoveTrailingSpaceCharAt {
	
	//Find start and end index after trimming spaces
    public static int[] findTrimIndexes(String str) {

        int start = 0;
        int end = str.length() - 1;

        // Trim leading spaces
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }
    
    //Create substring using charAt()
    public static String createSubstring(String str, int start, int end) {

        StringBuilder result = new StringBuilder();

        for (int i = start; i <= end; i++) {
            result.append(str.charAt(i));
        }

        return result.toString();
    }
    
    //Compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        // User input
	        String userInput = sc.nextLine();

	        // Custom trim logic
	        int[] indexes = findTrimIndexes(userInput);
	        String customTrimmed = createSubstring(userInput, indexes[0], indexes[1]);

	        // Built-in trim
	        String builtInTrimmed = userInput.trim();

	        // Compare results
	        boolean isSame = compareStrings(customTrimmed, builtInTrimmed);

	        // Display output
	        System.out.println("Custom Trimmed String : [" + customTrimmed + "]");
	        System.out.println("Built-in Trimmed String : [" + builtInTrimmed + "]");
	        System.out.println("Are both strings equal? : " + isSame);

	        sc.close();
		
		

	}

}
