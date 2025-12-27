package scenarioBased;

import java.util.Scanner;
public class ElectionManager {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int candidate1Votes = 0;
        int candidate2Votes = 0;
        int candidate3Votes = 0;
        
        
        while (true) {

            System.out.print("\nEnter voter age (or -1 to exit): ");
            int age = sc.nextInt();

            
            if (age == -1) {
                break;
            }

            // Check voting eligibility
            if (age >= 18) {
                System.out.println("You are eligible to vote.");
                System.out.println("Cast your vote:");
                System.out.println("1 - Candidate A");
                System.out.println("2 - Candidate B");
                System.out.println("3 - Candidate C");

                int vote = sc.nextInt();

                //Counting vote
                if (vote == 1) {
                    candidate1Votes++;
                } else if (vote == 2) {
                    candidate2Votes++;
                } else if (vote == 3) {
                    candidate3Votes++;
                } else {
                    System.out.println("Invalid vote! Vote not recorded.");
                }

            } else {
                System.out.println("You are not eligible to vote.");
            }
        }

        // Displaying final results
        System.out.println(" Election Results ");
        System.out.println("Candidate A Votes: " + candidate1Votes);
        System.out.println("Candidate B Votes: " + candidate2Votes);
        System.out.println("Candidate C Votes: " + candidate3Votes);

        sc.close();
	}

}
