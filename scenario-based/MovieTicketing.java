package scenarioBased;

import java.util.Scanner;


public class MovieTicketing {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean customers=true;
		
		while(customers) {
			
			//Amount
			int totalAmount=0;
			System.out.println("1. Action Movie \n2. Comedy Movie \n3. Horror Movie \n4. Drama Movie \nEnter Movie Type :");
			int movieType=sc.nextInt();
			sc.nextLine();
			
			switch(movieType) {
			case 1:
				totalAmount+=200;
				System.out.println("Movie Selected : Action.. ");
				break;
			case 2:
				totalAmount+=300;
				System.out.println("Movie Selected : Comedy.. ");
				break;
			case 3:
				totalAmount+=350;
				System.out.println("Movie Selected : Horror.. ");
				break;
			case 4:
				totalAmount+=150;
				System.out.println("Movie Selected : Drama.. ");
				break;	
			}
			
			//Seat Type selection
			System.out.println("Select the type of Seat (Gold/Silver)");
			String seatType=sc.nextLine().toLowerCase();
			//Seating pricing
			if(seatType.equals("gold")) {
				System.out.println("Gold Seat Selected");
				totalAmount+=200;
			}else if(seatType.equals("silver")) {
				System.out.println("Silver Seat Selected");
				totalAmount+=150;
			}else {
				System.out.println("Invalid  Seat Type Selected  ...!");
			}
			
			//input for snacks
			System.out.print("You want Snacks (Yes/No)  :");
			String snacks=sc.nextLine().toLowerCase();
			if(snacks.equals("yes")) {
				System.out.println("You Opted for Snacks !");
				totalAmount+=500;
			}
			
			
			//Billing Summary
			System.out.println("------Billing Summary-------");
			System.out.println("Seat Type :"+seatType);
			System.out.println("Snacks :"+snacks);
			System.out.println("Total Bill :"+totalAmount);
			
			//Hand Over to next Customer
			System.out.println("\nIf any other Customer in Line enter Yes otherwise No ");
			String exit=sc.nextLine().toLowerCase();
			if(exit.equals("no")) {
				customers=false;
			}
			
		}
		
	}
}
