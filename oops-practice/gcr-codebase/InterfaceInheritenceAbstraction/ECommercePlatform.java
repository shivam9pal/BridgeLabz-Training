package week02.gcrcodebase.abstractinterface;

import java.util.ArrayList;
import java.util.List;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {

    private String productId;
    private String name;
    private double price;
    // constructor
    Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // getters and setters 
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // abstract method
    public abstract double calculateDiscount();

    // concrete method
    public void displayDetails() {
        System.out.printf("Product ID   : %s%n", productId);
        System.out.printf("Product Name : %s%n", name);
        System.out.printf("Price        : %.2f%n", price);
    }
}

class Electronics extends Product implements Taxable {

    Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; 
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; 
    }

    @Override
    public String getTaxDetails() {
        return "18% GST on Electronics";
    }
}

class Clothing extends Product implements Taxable {

    Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; 
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12; 
    }

    @Override
    public String getTaxDetails() {
        return "12% GST on Clothing";
    }
}

class Groceries extends Product {

    Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; 
    }
}

public class ECommercePlatform {
	 // polymorphic method
	public static void calculateFinalPrice(List<Product> products) {

        for (Product p : products) {

            p.displayDetails();

            double tax = 0;

            if (p instanceof Taxable) {
                Taxable t = (Taxable) p;
                tax = t.calculateTax();
                System.out.println("Tax Info     : " + t.getTaxDetails());
            } else {
                System.out.println("Tax Info     : No tax applicable");
            }

            double discount = p.calculateDiscount();
            double finalPrice = p.getPrice() + tax - discount;

            System.out.printf("Discount     : %.2f%n", discount);
            System.out.printf("Final Price  : %.2f%n", finalPrice);
        }
    }
	
	public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        Product p1 = new Electronics("P101", "Laptop", 60000);
        Product p2 = new Clothing("P102", "Jacket", 3000);
        Product p3 = new Groceries("P103", "Rice Bag", 1200);

        products.add(p1);
        products.add(p2);
        products.add(p3);

        calculateFinalPrice(products);
    }

   
    
}
