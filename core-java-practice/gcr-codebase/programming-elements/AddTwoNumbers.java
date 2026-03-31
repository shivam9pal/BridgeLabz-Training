package practiceProblemDay1;
import java.util.Scanner;

public class AddTwoNumbers {

	public static void main(String[] args) {
		 	Scanner sc = new Scanner(System.in);
			// Taking User input
	        System.out.print("Enter first number= ");
	        int a = sc.nextInt();

	        System.out.print("Enter second number= ");
	        int b = sc.nextInt();
			// Printing the sum of Both  numbers
	        int sum = a + b;
	        System.out.println("Sum = " + sum);

	}

}
