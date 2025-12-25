package week01.string.level1;

import java.util.Arrays;
import java.util.Scanner;

public class StringCharacterComparison {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine(); 
        scanner.close();

        // Get character arrays
        char[] userDefinedChars = stringToCharArrayManual(inputString);
        char[] builtInChars = stringToCharArrayBuiltIn(inputString);

       
        boolean areEqual = compareCharArrays(userDefinedChars, builtInChars);

        System.out.println("Original String: " + inputString);
        System.out.println("User-defined char array: " + Arrays.toString(userDefinedChars));
        System.out.println("Built-in .toCharArray() array: " + Arrays.toString(builtInChars));
        
        if (areEqual) {
            System.out.println("Comparison Result: The arrays are identical.");
        } else {
            System.out.println("Comparison Result: The arrays are different.");
        }
    }

   
    public static char[] stringToCharArrayManual(String str) {
        if (str == null) {
            return new char[0]; 
            // Handle null input gracefully
        }
        int length = str.length();
        char[] charArray = new char[length];
        for (int i = 0; i < length; i++) {
            charArray[i] = str.charAt(i); 
        }
        return charArray;
    }

   
    public static char[] stringToCharArrayBuiltIn(String str) {
        if (str == null) {
            return new char[0]; 
        }
        return str.toCharArray();
    }

    
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        return Arrays.equals(arr1, arr2);
    }
}
