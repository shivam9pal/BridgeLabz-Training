package week02.gcrcodebase.abstractinterface;

import java.util.ArrayList;
import java.util.List;

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem {

    private String itemName;
    private double price;
    private int quantity;

    // constructor
    FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // getters 
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // restricted setters 
    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    // abstract method
    public abstract double calculateTotalPrice();

    // concrete method
    public void getItemDetails() {
        System.out.printf("Item Name  : %s%n", itemName);
        System.out.printf("Price      : %.2f%n", price);
        System.out.printf("Quantity   : %d%n", quantity);
    }
}

class VegItem extends FoodItem implements Discountable {

    VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10; 
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount on Veg Items";
    }
}

class NonVegItem extends FoodItem implements Discountable {
	// extra charge per item
    private static final double NON_VEG_CHARGE = 50; 

    NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity())
                + (NON_VEG_CHARGE * getQuantity());
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; 
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount on Non-Veg Items";
    }
}

public class OnlineFoodDeliverySystem {
	// polymorphic order processing
    public static void processOrder(List<FoodItem> items) {

        double grandTotal = 0;

        for (FoodItem item : items) {

            item.getItemDetails();

            double totalPrice = item.calculateTotalPrice();
            double discount = 0;

            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                discount = d.applyDiscount();
                System.out.println("Discount Info : " + d.getDiscountDetails());
            }

            double finalPrice = totalPrice - discount;
            grandTotal += finalPrice;

            System.out.printf("Total Price  : %.2f%n", totalPrice);
            System.out.printf("Discount     : %.2f%n", discount);
            System.out.printf("Final Price  : %.2f%n", finalPrice);
            System.out.println("");
        }

        System.out.printf("Grand Total  : %.2f%n", grandTotal);
    }
	public static void main(String[] args) {
		List<FoodItem> order = new ArrayList<>();

        FoodItem f1 = new VegItem("Paneer Butter Masala", 250, 2);
        FoodItem f2 = new NonVegItem("Chicken Biryani", 300, 1);

        order.add(f1);
        order.add(f2);

        processOrder(order);
    }

}


