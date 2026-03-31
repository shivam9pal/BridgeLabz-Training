package week01.string.level2;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RockPaperScissor {
	//Genrating computer Output
	public static String computerResponse() {
		
		//Genrating Random Value fom 0-3 
		Random rand=new Random();
		String[] response = {"Rock", "Paper", "Scissors"};
		int cResponse=rand.nextInt(3);
		String computerOutput=response[cResponse];
		return computerOutput;
	}
	
	//Making the user play the Game 
	public static void playGame(int no) {
        Scanner sc = new Scanner(System.in);
        int userWin = 0;
        int comWin = 0;
        int draw = 0;
        int gamesPlayed = 0;
        List<String> gameResults = new ArrayList<>(); 

        System.out.println("Choose the options: 'r' for Rock, 'p' for Paper, 's' for Scissors");

        while (gamesPlayed < no) {
            System.out.print("Game " + (gamesPlayed + 1) + ": Enter your choice (r/p/s): ");
            String userInput = sc.nextLine().trim().toLowerCase();
            String userChoice;

            if (userInput.equals("r")) {
                userChoice = "Rock";
            } else if (userInput.equals("p")) {
                userChoice = "Paper";
            } else if (userInput.equals("s")) {
                userChoice = "Scissors";
            } else {
                System.out.println("Invalid input. Please enter r, p, or s.");
                continue; 
                // Skip the rest of the loop iteration and ask for input again
            }

            String comInput = computerResponse();
            int winner = findWinner(userChoice, comInput);
            String resultMsg;

            if (winner == 1) {
                userWin++;
                resultMsg = "User Wins!";
            } else if (winner == -1) {
                comWin++;
                resultMsg = "Computer Wins!";
            } else {
                draw++;
                resultMsg = "It's a Draw!";
            }

            gameResults.add("Game " + (gamesPlayed + 1) + ": User chose " + userChoice + ", Computer chose " + comInput + " -> " + resultMsg);
            gamesPlayed++;
        }
        
        sc.close();
        displayResults(gameResults, userWin, comWin, draw, gamesPlayed);
    }
	
	
	public static String[][] calculateStats(int userWins, int comWins, int totalGames) {
        double userWinPercent = (totalGames == 0) ? 0 : (double) userWins / totalGames * 100;
        double comWinPercent = (totalGames == 0) ? 0 : (double) comWins / totalGames * 100;

        // Format to one decimal place
        String userPercentStr = String.format("%.1f%%", userWinPercent);
        String comPercentStr = String.format("%.1f%%", comWinPercent);

        // 
        String[][] stats = {
            {"User Win Percentage", userPercentStr},
            {"Computer Win Percentage", comPercentStr}
        };
        return stats;
    }
	
	public static int findWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return 0; // Draw
        } else if (
            (userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
            (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
            (userChoice.equals("Scissors") && computerChoice.equals("Paper"))
        ) {
            return 1; 
        } else {
            return -1;
        }
    }
	
	public static void displayResults(List<String> results, int userWins, int comWins, int draws, int totalGames) {
        System.out.println("\n--- Individual Game Results ---");
        for (String result : results) {
            System.out.println(result);
        }

        System.out.println("\n--- Game Statistics ---");
        System.out.printf("| %-20s | %-10s |\n", "Category", "Count");
        System.out.printf("| %-20s | %-10d |\n", "Games Played", totalGames);
        System.out.printf("| %-20s | %-10d |\n", "User Wins", userWins);
        System.out.printf("| %-20s | %-10d |\n", "Computer Wins", comWins);
        System.out.printf("| %-20s | %-10d |\n", "Draws", draws);


        String[][] stats = calculateStats(userWins, comWins, totalGames);

        System.out.println("\n--- Winning Percentages ---");
        System.out.printf("| %-25s | %-15s |\n", "Metric", "Percentage");
        for (String[] stat : stats) {
            System.out.printf("| %-25s | %-15s |\n", stat[0], stat[1]);
        }
    }
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of games you want to play: ");
        if (sc.hasNextInt()) {
            int numGames = sc.nextInt();
            // the remaining newline character
            sc.nextLine(); 
            if (numGames > 0) {
                playGame(numGames);
            } else {
                System.out.println("Please enter a positive number of games.");
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }
        
    }

}
