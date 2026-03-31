package week02.scenario.ecommerceplatform;

public class Product {

    private int productId;
    private String productName;
    private double price;
    private int stock;
    private String category;

    public Product(int productId, String productName, double price, int stock, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void decreaseStock(int quantity) {
        if (quantity <= stock) {
            this.stock -= quantity;
        } else {
            throw new IllegalArgumentException("Insufficient stock!");
        }
    }

    public void increaseStock(int quantity) {
        this.stock += quantity;
    }

    @Override
    public String toString() {
        return "ID: " + productId
                + " | Name: " + productName
                + " | Price: Rs." + price
                + " | Stock: " + stock
                + " | Category: " + category;
    }
}
