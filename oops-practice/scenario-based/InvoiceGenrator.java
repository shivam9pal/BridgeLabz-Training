package week02.scenario;



public class InvoiceGenrator {
	//Breaking from ,
	public static String[] parseInvoice(String str) {
		str.trim();
		 return str.split(",");
	}
	
	//calculate amount
	public static int getTotalAmount(String str) {
		String[] userInput=parseInvoice(str);
		int totalAmount=0;
		
		//through String 
		for(String check:userInput) {
			String[] strAmount=check.trim().split("-");
			//calculating amount 
			String amountPart=strAmount[1].trim().split(" ")[0];
			int amount = Integer.parseInt(amountPart);
			System.out.println(amountPart);
			 totalAmount += amount;
		}
		return totalAmount;
	}
	public static void main(String[] args) {
		String input = "Logo Design - 3000 INR, Web Page - 4500 INR";
		int total =getTotalAmount(input);
        System.out.println("Invoice Details:");
        System.out.println("Total Invoice Amount: " + total + " INR");

	}

}
