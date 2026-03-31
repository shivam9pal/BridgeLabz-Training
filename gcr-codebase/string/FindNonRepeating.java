package week01.string.level3;

import java.util.Scanner;
public class FindNonRepeating {
	//finding non repeating character
	public static char firstNonRepeatingChar(String text) {

        
        int[] frequency = new int[256];

        //count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }

        // If no non-repeating character found
        return '\0';
    }
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();	

        char result = firstNonRepeatingChar(input);

        // Display result
        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        sc.close();
    }

}
