package week01.string.level3;

import java.util.Scanner;
public class CountUnique {
	//Custom Length
	public static int customLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }
	
	// Finding the unique character
	public static char[] findUniqueCharacters(String text) {
        int length = customLength(text);

        // Temporary array to store unique 
        char[] temp = new char[length];
        int uniqueCount = 0;

    
        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;

            
            for (int j = 0; j < i; j++) {
                if (currentChar == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[uniqueCount++] = currentChar;
            }
        }

        // Create final array with exact size
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }

        return result;
    }

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// Taking user input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Finding unique characters
        char[] uniqueChars = findUniqueCharacters(input);

        
        System.out.print("Unique characters: ");
        for (char ch : uniqueChars) {
            System.out.print(ch + " ");
        }

        sc.close();
		
	}

}
