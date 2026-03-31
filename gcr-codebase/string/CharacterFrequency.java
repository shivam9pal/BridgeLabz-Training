package week01.string.level3;

import java.util.Scanner;

public class CharacterFrequency {

    // Method to find character frequency
    public static String[][] findCharacterFrequency(String text) {

        
        int[] frequency = new int[256];

        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Count unique characters
        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] != 0) {
                uniqueCount++;
                frequency[text.charAt(i)] = -frequency[text.charAt(i)];
            }
        }

        //Create 2D array
        String[][] result = new String[uniqueCount][2];

        
        frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        //Store character and frequency
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] != 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(frequency[ch]);
                index++;
                frequency[ch] = 0; 
            }
        }

        return result;
    }

    // Method to display 2D array in tabular format
    public static void displayResult(String[][] data) {
        System.out.println("\nCharacter\tFrequency");
        
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "    " + data[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Calling methods
        String[][] frequencyArray = findCharacterFrequency(input);
        displayResult(frequencyArray);

        sc.close();
    }
}
