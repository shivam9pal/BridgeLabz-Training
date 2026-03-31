package scenarioBased;

import java.util.Scanner;
public class CoffeeCounter {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		double gstRate=0.1;
		
		//Serving the customer
		while(true) {
            System.out.println("\nEnter coffee type (Espresso / Latte / Cappuccino) or type 'exit' to stop:");
            String coffeeType = sc.nextLine().toLowerCase();
            
            //Checking exits command
            if(coffeeType.equals("exit")) {
            	System.out.println("Thank You For Visting the Cafe  !!!!");
            	break;
            }
            
            //Taking User quantity
            System.out.print("Enter the Quantity :");
            int quantity=sc.nextInt();
            sc.nextLine();
            
            double price=0;
            
            switch(coffeeType) {
            case"expresso":price=120;
            break;
            
            case"latte":price=150;
            break;
            
            case"cappuccino":price=170;
            break;
            
            default:System.out.println("Invalid Coffe Type !!?");
            continue;
            }   
            
            
            // calculating bill
            double total=price*quantity;
            double gstAmount=total*gstRate;
            double finalBill=total+gstAmount;
            
            // Printing the Bill details
            System.out.println("/n-----------Bill Details------------");
            System.out.println("Coffee Type :"+ coffeeType);
            System.out.println("Quantity    : " + quantity);
            System.out.println("Base Amount : ₹" + total);
            System.out.println("GST (5%)    : ₹" + gstAmount);
            System.out.println("Total Bill  : ₹" + finalBill);
		}
		
		sc.close();
	}

}
