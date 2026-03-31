package week01.string.level3;

import java.util.Scanner;

public class UniqueCharacter {

    // Method to find unique characters
    public static char[] uniqueCharacters(String text) {

        char[] temp = new char[text.length()];
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (current == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[count++] = current;
            }
        }

        // Created exact size array
        char[] uniqueChars = new char[count];
        for (int i = 0; i < count; i++) {
            uniqueChars[i] = temp[i];
        }

        return uniqueChars;
    }

    // Method to find frequency 
    public static String[][] characterFrequency(String text) {

       
        int[] frequency = new int[256];

        
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        
        char[] uniqueChars = uniqueCharacters(text);

        
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            char ch = uniqueChars[i];
            result[i][0] = String.valueOf(ch);
            result[i][1] = String.valueOf(frequency[ch]);
        }

        return result;
    }

    // Display method
    public static void displayResult(String[][] data) {
        System.out.println("\nCharacter\tFrequency");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] frequencyArray = characterFrequency(input);
        displayResult(frequencyArray);

        sc.close();
    }
}
