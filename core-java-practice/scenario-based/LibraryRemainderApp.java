package scenarioBased;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibraryRemainderApp {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		final int fine=5;
		System.out.println("-----Fine Calculator----- ");
		//Calculating fine for five returns 
		for(int i=1;i<=5;i++) {
			System.out.printf("\nEnter the details for book %d",i);
			System.out.println("\nEnter the due date (yyyy-mm-dd)");
			LocalDate dueDate= LocalDate.parse(sc.next());
			System.out.println("Enter the return date (yyyy-mm-dd)");
			LocalDate returnDate= LocalDate.parse(sc.next());
			
			//Checking the return date and due date 
			if(dueDate.isAfter(returnDate)) {
				long days=ChronoUnit.DAYS.between(dueDate, returnDate);
				long totalFine=days*fine;
				System.out.println("Late by " + days + " days");
                System.out.println("Fine Amount: ₹" + totalFine);
						
			}else {
				System.out.println("Congratulation No fine on return within due date !!...");
			}
			
		}
		
		
		sc.close();
	}

}
