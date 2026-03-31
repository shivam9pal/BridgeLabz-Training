package week02.scenario.inventorymanagement;

public class Product {

    private int productId;
    private String productName;
    private String category;
    private double price;
    private int currentStock;
    private int reorderLevel;
    private String supplier;
    private String location;

    public Product(int productId, String productName, String category, double price, int currentStock, int reorderLevel, String supplier, String location) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.currentStock = currentStock;
        this.reorderLevel = reorderLevel;
        this.supplier = supplier;
        this.location = location;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int stock) {
        this.currentStock = stock;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addStock(int quantity) {
        this.currentStock += quantity;
    }

    public void removeStock(int quantity) throws OutOfStockException {
        if (quantity > currentStock) {
            throw new OutOfStockException("Insufficient stock! Available: " + currentStock + ", Requested: " + quantity);
        }
        this.currentStock -= quantity;
    }

    public boolean isLowStock() {
        return currentStock <= reorderLevel;
    }

    public double getInventoryValue() {
        return currentStock * price;
    }

    @Override
    public String toString() {
        return "ID: " + productId
                + " | Name: " + productName
                + " | Category: " + category
                + " | Price: Rs." + String.format("%.2f", price)
                + " | Stock: " + currentStock
                + " | Reorder Level: " + reorderLevel
                + " | Supplier: " + supplier
                + " | Location: " + location;
    }

    public String getStockStatus() {
        if (currentStock == 0) {
            return "OUT OF STOCK";
        } else if (isLowStock()) {
            return "LOW STOCK";
        } else {
            return "ADEQUATE STOCK";
        }
    }
}
