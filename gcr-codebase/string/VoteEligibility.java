package week01.string.level2;

import java.util.Scanner;
import java.util.Random;
public class VoteEligibility {
	
	//Get Random Ages 
	public static int[] getRandomAge(int n) {
		int[] ages =new int[n];
		Random rand=new Random();
		
		for (int i = 0; i < n; i++) {
        // Generating random 2-digit age (10 to 99)
            ages[i] = rand.nextInt(90) + 10;
        }
		return ages;
	}
	
	
	//checking voting eligibility
	public static String[][] checkVotingEligibility(int[] ages) {

        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {

            int age = ages[i];
            result[i][0] = String.valueOf(age);

            // Validation for negative age
            if (age < 0) {
                result[i][1] = "false";
            }
            
            else if (age >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }

        return result;
    }
	
	//Displaying the result in a grid manner
	public static void displayResult(String[][] data) {

        System.out.println("Age\tCan Vote");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Taking user input for number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Generate ages
        int[] ages = getRandomAge(n);

        // Check voting eligibility
        String[][] votingResult = checkVotingEligibility(ages);

        // Display result
        displayResult(votingResult);

        sc.close();
		
	}
}
