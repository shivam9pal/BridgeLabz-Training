package practiceProblemDay1;
import java.util.Scanner;

public class SimpleIntrest {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking the User input 
        System.out.print("Enter Principal= ");
        double principal = sc.nextDouble();

        System.out.print("Enter Rate= ");
        double rate = sc.nextDouble();

        System.out.print("Enter Time= ");
        double time = sc.nextDouble();
        // Displaying the Intrest
        double si = (principal * rate * time) / 100;
        System.out.println("Simple Interest = " + si);
    }
}
