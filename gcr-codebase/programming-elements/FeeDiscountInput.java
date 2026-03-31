package week01.programmingElements;
import java.util.Scanner;

public class FeeDiscountInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking User Input 
        System.out.print("Enter fee: ");
        double fee = sc.nextDouble();

        System.out.print("Enter discount percentage: ");
        double discountPercent = sc.nextDouble();
        // Calculation 
        double discount = fee * discountPercent / 100;
        double finalFee = fee - discount;
        // Displaying the Discount 
        System.out.println("The discount amount is INR " + discount +
                " and final discounted fee is INR " + finalFee);
    }
}
