package scenarioBased;


import java.util.Scanner;
public class MetroCard {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 
		// Initial card Balance
		double intialBalance=200.0;
		
		System.out.println("Welcome Delhi Metro System !");
		System.out.println("Initial Balance  :"+intialBalance);
		
		while(true) {
			System.out.print("Enter the distance Tarvelled in Km :");
			int distance=sc.nextInt();
			
			// Fare Calculation using ternary operator 
			int fare=(distance <=5 )?20:
					 (distance <=10)?40:60;	
			
			// cehk balance 
			if(intialBalance >=fare) {
				intialBalance -=fare;
				System.out.println("Fare deducted: ₹ " + fare);
				 System.out.println("Remaining balance: ₹" + intialBalance);
			}else {
                System.out.println("Insufficient balance! Please recharge your card.");
                break;
            }
			
			
		}
		
		 System.out.println("Thank you for using Delhi Metro 🚇");
	     sc.close();
	}

}
