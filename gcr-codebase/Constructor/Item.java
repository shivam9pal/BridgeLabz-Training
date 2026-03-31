package week02.gcrCodebase.constructor;

public class Item {
	 // Instance variable
    String productName;  
    double price;        
    // Class variable
    static int totalProducts = 0;  // Class variable

    //constructor
    Item(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    // Instance method
    void displayProductDetails() {
        System.out.println("Product: " + productName);
        System.out.println("Price: " + price);
    }

    // Class method
    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    public static void main(String[] args) {
        Item p1 = new Item("Laptop", 50000);
        Item p2 = new Item("Mouse", 500);

        p1.displayProductDetails();
        p2.displayProductDetails();

        Item.displayTotalProducts();
    }
}

