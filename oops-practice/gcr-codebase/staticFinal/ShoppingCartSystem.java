package week02.gcrcodebase.staticfinal;


class Product{
	private static double discount = 10.0;
    private final String productID;
    private String productName;
    private double price;
    private int quantity;
    
 // Constructor
    public Product(String productName, String productID, double price, int quantity) {
        this.productName = productName;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }
    
 // Static method
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
 // Display product details
    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Price after Discount: " + (price - (price * discount / 100)));
        }
    }
	
}


public class ShoppingCartSystem extends Product {

	public ShoppingCartSystem(String productName, String productID, double price, int quantity) {
		super(productName, productID, price, quantity);
		
	}
	
	public static void main(String[] args) {
		ShoppingCartSystem p1 = new ShoppingCartSystem("Laptop", "P001", 1200.0, 5);
		 p1.displayProductDetails();
	        System.out.println();
	}
}
