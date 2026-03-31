package week02.scenario.inventorymanagement;

import java.util.*;

public class InventoryService {

    private Map<Integer, Product> inventory;
    private List<AlertService> alertServices;
    private List<String> transactionLog;

    public InventoryService() {
        this.inventory = new HashMap<>();
        this.alertServices = new ArrayList<>();
        this.transactionLog = new ArrayList<>();
        initializeInventory();
    }

    private void initializeInventory() {
        inventory.put(1001, new Product(1001, "Laptop Dell XPS", "Electronics", 75000, 8, 3, "Dell India", "Shelf A1"));
        inventory.put(1002, new Product(1002, "Mouse Logitech", "Electronics", 1200, 45, 10, "Logitech", "Shelf B2"));
        inventory.put(1003, new Product(1003, "Keyboard Mechanical", "Electronics", 4500, 2, 5, "Corsair", "Shelf B3"));
        inventory.put(1004, new Product(1004, "Monitor 24 inch", "Electronics", 15000, 5, 3, "LG", "Shelf C1"));
        inventory.put(1005, new Product(1005, "USB Cable 2m", "Accessories", 250, 120, 30, "Belkin", "Shelf D1"));
        inventory.put(1006, new Product(1006, "HDMI Cable 3m", "Accessories", 350, 0, 20, "Philips", "Shelf D2"));
        inventory.put(1007, new Product(1007, "Desk Lamp LED", "Furniture", 2000, 8, 4, "IKEA", "Shelf E1"));
        inventory.put(1008, new Product(1008, "Office Chair", "Furniture", 8000, 3, 2, "Herman Miller", "Shelf F1"));
    }

    public void registerAlertService(AlertService alert) {
        alertServices.add(alert);
        System.out.println("✓ Alert service registered: " + alert.getAlertType());
    }

    public void addProduct(int productId, String productName, String category, double price, int stock, int reorderLevel, String supplier, String location) {
        Product product = new Product(productId, productName, category, price, stock, reorderLevel, supplier, location);
        inventory.put(productId, product);
        logTransaction("Added new product: " + productName + " (ID: " + productId + ")");
        System.out.println("✓ Product added successfully!");
    }

    public void updateProductPrice(int productId, double newPrice) throws Exception {
        Product product = inventory.get(productId);
        if (product == null) {
            throw new Exception("Product not found!");
        }
        double oldPrice = product.getPrice();
        product.setPrice(newPrice);
        logTransaction("Updated price for " + product.getProductName() + ": Rs." + oldPrice + " → Rs." + newPrice);
        System.out.println("✓ Price updated successfully!");
    }

    public void updateReorderLevel(int productId, int newLevel) throws Exception {
        Product product = inventory.get(productId);
        if (product == null) {
            throw new Exception("Product not found!");
        }
        int oldLevel = product.getReorderLevel();
        product.setReorderLevel(newLevel);
        logTransaction("Updated reorder level for " + product.getProductName() + ": " + oldLevel + " → " + newLevel);
        System.out.println("✓ Reorder level updated successfully!");
    }

    public void addStock(int productId, int quantity) throws Exception {
        Product product = inventory.get(productId);
        if (product == null) {
            throw new Exception("Product not found!");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0!");
        }

        product.addStock(quantity);
        logTransaction("Added " + quantity + " units of " + product.getProductName()
                + ". New stock: " + product.getCurrentStock());
        System.out.println("✓ Stock added successfully! New stock: " + product.getCurrentStock());
    }

    public void removeStock(int productId, int quantity) throws OutOfStockException, Exception {
        Product product = inventory.get(productId);
        if (product == null) {
            throw new Exception("Product not found!");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0!");
        }

        product.removeStock(quantity);
        logTransaction("Removed " + quantity + " units of " + product.getProductName()
                + ". Remaining stock: " + product.getCurrentStock());
        System.out.println("✓ Stock removed successfully! Remaining stock: " + product.getCurrentStock());

        // Check if stock is now low
        if (product.isLowStock()) {
            sendLowStockAlert(product);
        }
        if (product.getCurrentStock() == 0) {
            sendOutOfStockAlert(product);
        }
    }

    public Product getProduct(int productId) {
        return inventory.get(productId);
    }

    public void displayAllProducts() {
        System.out.println("\n" + "=".repeat(120));
        System.out.println("COMPLETE INVENTORY");
        System.out.println("=".repeat(120));
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory!");
        } else {
            for (Product product : inventory.values()) {
                System.out.println(product + " | Status: " + product.getStockStatus());
            }
        }
        System.out.println("=".repeat(120));
    }

    public void displayProductDetails(int productId) {
        Product product = inventory.get(productId);
        if (product != null) {
            System.out.println("\n" + "=".repeat(120));
            System.out.println("PRODUCT DETAILS");
            System.out.println("=".repeat(120));
            System.out.println(product);
            System.out.println("-".repeat(120));
            System.out.println("Stock Status: " + product.getStockStatus());
            System.out.println("Inventory Value: Rs." + String.format("%.2f", product.getInventoryValue()));
            System.out.println("=".repeat(120));
        } else {
            System.out.println("✗ Product not found!");
        }
    }

    public void displayLowStockItems() {
        System.out.println("\n" + "=".repeat(120));
        System.out.println("LOW STOCK ITEMS");
        System.out.println("=".repeat(120));
        boolean found = false;
        for (Product product : inventory.values()) {
            if (product.isLowStock()) {
                System.out.println(product + " | Status: " + product.getStockStatus());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No low stock items!");
        }
        System.out.println("=".repeat(120));
    }

    public void displayOutOfStockItems() {
        System.out.println("\n" + "=".repeat(120));
        System.out.println("OUT OF STOCK ITEMS");
        System.out.println("=".repeat(120));
        boolean found = false;
        for (Product product : inventory.values()) {
            if (product.getCurrentStock() == 0) {
                System.out.println(product + " | Status: " + product.getStockStatus());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No out of stock items!");
        }
        System.out.println("=".repeat(120));
    }

    public void displayInventorySummary() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("INVENTORY SUMMARY");
        System.out.println("=".repeat(80));

        int totalProducts = inventory.size();
        int lowStockCount = 0;
        int outOfStockCount = 0;
        double totalInventoryValue = 0;
        int totalUnits = 0;

        for (Product product : inventory.values()) {
            if (product.isLowStock()) {
                lowStockCount++;
            }
            if (product.getCurrentStock() == 0) {
                outOfStockCount++;
            }
            totalInventoryValue += product.getInventoryValue();
            totalUnits += product.getCurrentStock();
        }

        System.out.println("Total Products: " + totalProducts);
        System.out.println("Total Units in Stock: " + totalUnits);
        System.out.println("Low Stock Items: " + lowStockCount);
        System.out.println("Out of Stock Items: " + outOfStockCount);
        System.out.println("Total Inventory Value: Rs." + String.format("%.2f", totalInventoryValue));
        System.out.println("=".repeat(80));
    }

    public void displayTransactionLog() {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("TRANSACTION LOG");
        System.out.println("=".repeat(100));
        if (transactionLog.isEmpty()) {
            System.out.println("No transactions recorded!");
        } else {
            int count = 1;
            for (String transaction : transactionLog) {
                System.out.println(count + ". " + transaction);
                count++;
            }
        }
        System.out.println("=".repeat(100));
    }

    private void logTransaction(String transaction) {
        String timestamp = new java.time.LocalDateTime.now().toString();
        transactionLog.add("[" + timestamp + "] " + transaction);
    }

    private void sendLowStockAlert(Product product) {
        for (AlertService alert : alertServices) {
            alert.sendLowStockAlert(product);
        }
    }

    private void sendOutOfStockAlert(Product product) {
        for (AlertService alert : alertServices) {
            alert.sendOutOfStockAlert(product);
        }
    }

    public void sendReorderAlert(int productId, int quantity) throws Exception {
        Product product = inventory.get(productId);
        if (product == null) {
            throw new Exception("Product not found!");
        }
        for (AlertService alert : alertServices) {
            alert.sendReorderAlert(product, quantity);
        }
    }
}
