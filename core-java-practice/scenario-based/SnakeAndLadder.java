package scenarioBased;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SnakeAndLadder {
	//Making Dice
	public static int dice() {
		return (int)(Math.random()*(6)+1);
	}
	//get Option
	public static int option() {
		return (int)(Math.random()*(3)+1);
	}
	//Display Stats
	public static void displayStats(HashMap<Integer,Integer> stats){
		System.out.println("Dice Rolls\tPosition");
		for (Map.Entry<Integer, Integer> entry : stats.entrySet()) {
	        System.out.println(entry.getKey() +"\t"+ entry.getValue());
	                           
	    }
		
	}
	
	//playing game
	public static void playGameSingle() {
		HashMap<Integer,Integer> progressCard=new HashMap<>();
		
		int playerScore=0;
		int noOfDiceRolls=0;
		
		
		while(playerScore!=100) {
			//Increasing dice roll
			noOfDiceRolls++;
			int option=option();
			int diceRolls=dice();
//			System.out.println(diceRolls+" "+option);
			
			if(option==1) {
				//No play
				System.out.println("The PLayer Got No Play Option");
				System.out.println("The Position of Player :"+playerScore);
				System.out.println("---------------------------------------------------");
			}else if(option==2) {
				//ladder
				if(playerScore+diceRolls>100) {
					System.out.println("The PLayer got Ladder  ");
					System.out.println("The Position of Player :"+playerScore);
					System.out.println("The Dice score of Player :"+diceRolls);
					System.out.println("The PLayer Cannot Move ahead as getting grater than 100 ");
					System.out.println("---------------------------------------------------");
				}else {
					System.out.println("The PLayer got Ladder Option ");
					System.out.println("The Position of Player :"+playerScore);
					System.out.println("The Dice score of Player :"+diceRolls);
					System.out.println("---------------------------------------------------");
					playerScore+=diceRolls;
				}
			}else if(option==3){
				//snake
				if(playerScore-diceRolls<0) {
					System.out.println("The PLayer got Snake  ");
					System.out.println("The Position of Player :"+playerScore);
					System.out.println("The Dice score of Player :-"+diceRolls);
					System.out.println("The PLayer Cannot Move below 0 as getting Snake ");
					System.out.println("---------------------------------------------------");
					playerScore=0;
				}else {
					
					System.out.println("The PLayer got Snake  ");
					System.out.println("The Position of Player :"+playerScore);
					System.out.println("The Dice score of Player :-"+diceRolls);
					System.out.println("---------------------------------------------------");
					playerScore-=diceRolls;
				}
				
			}
			//Storing stats
			progressCard.put(noOfDiceRolls, playerScore);
		}
		displayStats(progressCard);
	}
	
	//for Dual Player
	public static void playGameDual() {
		//For storing progress report
		HashMap<Integer,Integer> progressCardPlayerOne=new HashMap<>();
		HashMap<Integer,Integer> progressCardPlayerTwo=new HashMap<>();
		int playerScoreOne=0;
		int noOfDiceRollsOne=0;
		int playerScoreTwo=0;
		int noOfDiceRollsTwo=0;
		int playerPlay=1;
		
		System.out.println("Game Start");
		System.out.printf("Initial Position: %d",playerScoreOne);
		System.out.printf("/nInitial Position: %d",playerScoreTwo);
		System.out.println("----------------------------------");

		
		while(playerScoreOne!=100 && playerScoreTwo!=100) {
			
			//getting option and dice 
			int option=option();
			int diceRolls=dice();
			
			if(playerPlay%2==0) {
				//Player one plays
				if(option==1) {
					//No play
					//Just changing turn
					System.out.println("The PLayer A Got No Play Option");
					System.out.println("The Position of Player :"+playerScoreOne);
					System.out.println("---------------------------------------------------");
					noOfDiceRollsOne++;
					playerPlay++;
				}else if(option==2) {
					//ladder
					//Not changing turn of player for ladder
					//Score shouldn't go above 100
					if(playerScoreOne+diceRolls>100) {
						System.out.println("The PLayer A got Ladder  ");
						System.out.println("The Position of Player :"+playerScoreOne);
						System.out.println("The Dice score of Player :"+diceRolls);
						System.out.println("The PLayer Cannot Move ahead as getting grater than 100 ");
						System.out.println("---------------------------------------------------");
						noOfDiceRollsOne++;
					}else {
						System.out.println("The PLayer A got Ladder Option ");
						System.out.println("The Position of Player :"+playerScoreOne);
						System.out.println("The Dice score of Player :"+diceRolls);
						System.out.println("---------------------------------------------------");
						noOfDiceRollsOne++;
						playerScoreOne+=diceRolls;
					}
				}else if(option==3){
					//snake
					//if player position gets below Zero
					if(playerScoreOne-diceRolls<0) {
						System.out.println("The PLayer A got Snake  ");
						System.out.println("The Position of Player :"+playerScoreOne);
						System.out.println("The Dice score of Player :-"+diceRolls);
						System.out.println("The PLayer Cannot Move below 0 as getting Snake ");
						System.out.println("---------------------------------------------------");
						noOfDiceRollsOne++;
						playerScoreOne=0;
						playerPlay++;
					}else {
						// Player position above zero
						System.out.println("The PLayer B got Snake  ");
						System.out.println("The Position of Player :"+playerScoreOne);
						System.out.println("The Dice score of Player :-"+diceRolls);
						System.out.println("---------------------------------------------------");
						noOfDiceRollsOne++;
						playerScoreOne-=diceRolls;
						playerPlay++;
					}
				}
				//Saving progress of player One
				progressCardPlayerOne.put(noOfDiceRollsOne,playerScoreOne);
				
			}else{
				//for player two
					if(option==1) {
						//No play
						System.out.println("The PLayer B Got No Play Option");
						System.out.println("The Position of Player :"+playerScoreTwo);
						System.out.println("---------------------------------------------------");
						noOfDiceRollsTwo++;
						playerPlay++;
					}else if(option==2) {
						//ladder
						//Not changing turn of player for ladder
						//Score shouldn't go above 100
						if(playerScoreTwo+diceRolls>100) {
							System.out.println("The PLayer B got Ladder  ");
							System.out.println("The Position of Player :"+playerScoreTwo);
							System.out.println("The Dice score of Player :"+diceRolls);
							System.out.println("The PLayer Cannot Move ahead as getting grater than 100 ");
							System.out.println("---------------------------------------------------");
							noOfDiceRollsTwo++;
						}else {
							System.out.println("The PLayer B got Ladder Option ");
							System.out.println("The Position of Player :"+playerScoreTwo);
							System.out.println("The Dice score of Player :"+diceRolls);
							System.out.println("---------------------------------------------------");
							noOfDiceRollsTwo++;
							playerScoreTwo+=diceRolls;
						}
					}else if(option==3){
						//snake
						//if player position gets below Zero
						if(playerScoreTwo-diceRolls<0) {
							System.out.println("The PLayer B got Snake  ");
							System.out.println("The Position of Player :"+playerScoreTwo);
							System.out.println("The Dice score of Player :-"+diceRolls);
							System.out.println("The PLayer Cannot Move below 0 as getting Snake ");
							System.out.println("---------------------------------------------------");
							noOfDiceRollsTwo++;
							playerScoreTwo=0;
							playerPlay++;
						}else {
							// Player position above zero
							System.out.println("The PLayer B got Snake  ");
							System.out.println("The Position of Player :"+playerScoreTwo);
							System.out.println("The Dice score of Player :-"+diceRolls);
							System.out.println("---------------------------------------------------");
							noOfDiceRollsTwo++;
							playerScoreTwo-=diceRolls;
							playerPlay++;
						}	
					}
					progressCardPlayerTwo.put(noOfDiceRollsTwo,playerScoreTwo);
				}
			
			}
		//Diplay stats
		if(playerPlay%2==0) {
			System.out.println("Hurray Player One Wins......");
		}else {
			System.out.println("Hurray Player Two Wins......");
		}
		System.out.println("--------------------------------------------------------");
		System.out.println("Every Turn's Of Player One ----");
		displayStats(progressCardPlayerOne);
		System.out.println("--------------------------------------------------------");
		System.out.println("Every Turn's Of Player Two ----");
		displayStats(progressCardPlayerTwo);
			
		}
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter 1 if You want to Play Single Player Or 0 for Dual Player Mode:");
		int gameMode=sc.nextInt();
		if(gameMode==1) {
			playGameSingle();
		}else {
			playGameDual();
		}
		
		
		
	}

}
