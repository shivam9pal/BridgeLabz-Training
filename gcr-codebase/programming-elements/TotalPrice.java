package week01.programmingElements.level2;

import java.util.Scanner;

public class TotalPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // taking user input 
        System.out.print("Enter unit price: ");
        double unitPrice = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        // Caluluting the totalPrice 
        double totalPrice = unitPrice * quantity;
        //Displaying the Total Price and Quantity
        System.out.println("The total purchase price is INR " 
                + totalPrice + " if the quantity " 
                + quantity + " and unit price is INR " + unitPrice);
    }
}

