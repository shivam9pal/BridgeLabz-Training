package week01.string.level3;

import java.util.Scanner;

public class CharacterFrequencyNested {

    // Method to find character frequency
    public static String[] findFrequency(String text) {

        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];

        
        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1;
        }

        // Nested loop to find frequency
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '0') {
                continue;
            }

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; 
                }
            }
        }

        // Count valid characters
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                count++;
            }
        }

        
        String[] result = new String[count];
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index++] = chars[i] + " : " + freq[i];
            }
        }

        return result;
    }

    // Display method
    public static void displayResult(String[] data) {
        System.out.println("\nCharacter Frequency:");
        for (String entry : data) {
            System.out.println(entry);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[] frequency = findFrequency(input);
        displayResult(frequency);

        sc.close();
    }
}
