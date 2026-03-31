package week02.scenario.inventorymanagement;

import java.util.*;

public class InventoryManagementApp {

    private InventoryService inventoryService;
    private Scanner scanner;
    private boolean isLoggedIn = false;
    private String userName;

    public InventoryManagementApp() {
        this.inventoryService = new InventoryService();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        InventoryManagementApp app = new InventoryManagementApp();
        app.run();
    }

    public void run() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                      INVENTORY MANAGEMENT SYSTEM                              ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");

        boolean running = true;
        while (running) {
            if (!isLoggedIn) {
                running = handleLoginMenu();
            } else {
                running = handleMainMenu();
            }
        }

        System.out.println("\n╔════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    Thank you for using the system! Goodbye!                     ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
        scanner.close();
    }

    // ====== LOGIN MENU ======
    private boolean handleLoginMenu() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("WAREHOUSE STAFF LOGIN");
        System.out.println("=".repeat(80));
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.println("=".repeat(80));
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                return false;
            default:
                System.out.println("✗ Invalid choice! Please try again.");
        }
        return true;
    }

    private void login() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("STAFF LOGIN");
        System.out.println("-".repeat(80));

        System.out.print("Enter Staff Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Password (demo: 1234): ");
        String password = scanner.nextLine().trim();

        if (password.equals("1234")) {
            userName = name;
            isLoggedIn = true;
            setupAlerts();
            System.out.println("✓ Welcome, " + name + "!");
        } else {
            System.out.println("✗ Invalid password!");
        }
    }

    private void setupAlerts() {
        // Register multiple alert services
        inventoryService.registerAlertService(new SystemAlert("Warehouse Management System"));
        inventoryService.registerAlertService(new EmailAlert("manager@warehouse.com"));
        inventoryService.registerAlertService(new SMSAlert("9876543210"));
    }

    // ====== MAIN MENU ======
    private boolean handleMainMenu() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("MAIN MENU - " + userName);
        System.out.println("=".repeat(80));
        System.out.println("1. View Inventory Summary");
        System.out.println("2. View All Products");
        System.out.println("3. View Product Details");
        System.out.println("4. Add New Product");
        System.out.println("5. Update Product Price");
        System.out.println("6. Update Reorder Level");
        System.out.println("7. Add Stock");
        System.out.println("8. Remove Stock");
        System.out.println("9. View Low Stock Items");
        System.out.println("10. View Out of Stock Items");
        System.out.println("11. Send Reorder Alert");
        System.out.println("12. View Transaction Log");
        System.out.println("13. Logout");
        System.out.println("14. Exit");
        System.out.println("=".repeat(80));
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                inventoryService.displayInventorySummary();
                break;
            case 2:
                inventoryService.displayAllProducts();
                break;
            case 3:
                viewProductDetails();
                break;
            case 4:
                addNewProduct();
                break;
            case 5:
                updateProductPrice();
                break;
            case 6:
                updateReorderLevel();
                break;
            case 7:
                addStock();
                break;
            case 8:
                removeStock();
                break;
            case 9:
                inventoryService.displayLowStockItems();
                break;
            case 10:
                inventoryService.displayOutOfStockItems();
                break;
            case 11:
                sendReorderAlert();
                break;
            case 12:
                inventoryService.displayTransactionLog();
                break;
            case 13:
                isLoggedIn = false;
                System.out.println("✓ Logged out successfully!");
                break;
            case 14:
                return false;
            default:
                System.out.println("✗ Invalid choice! Please try again.");
        }
        return true;
    }

    // ====== INVENTORY OPERATIONS ======
    private void viewProductDetails() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("VIEW PRODUCT DETAILS");
        System.out.println("-".repeat(80));

        System.out.print("Enter Product ID: ");
        int productId = getIntInput();

        inventoryService.displayProductDetails(productId);
    }

    private void addNewProduct() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("ADD NEW PRODUCT");
        System.out.println("-".repeat(80));

        System.out.print("Enter Product ID: ");
        int productId = getIntInput();

        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine().trim();

        System.out.print("Enter Category: ");
        String category = scanner.nextLine().trim();

        System.out.print("Enter Price (Rs.): ");
        double price = getDoubleInput();

        System.out.print("Enter Initial Stock: ");
        int stock = getIntInput();

        System.out.print("Enter Reorder Level: ");
        int reorderLevel = getIntInput();

        System.out.print("Enter Supplier Name: ");
        String supplier = scanner.nextLine().trim();

        System.out.print("Enter Location (Shelf): ");
        String location = scanner.nextLine().trim();

        inventoryService.addProduct(productId, productName, category, price, stock, reorderLevel, supplier, location);
    }

    private void updateProductPrice() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("UPDATE PRODUCT PRICE");
        System.out.println("-".repeat(80));

        System.out.print("Enter Product ID: ");
        int productId = getIntInput();

        Product product = inventoryService.getProduct(productId);
        if (product == null) {
            System.out.println("✗ Product not found!");
            return;
        }

        System.out.println("Current Price: Rs." + String.format("%.2f", product.getPrice()));
        System.out.print("Enter New Price (Rs.): ");
        double newPrice = getDoubleInput();

        try {
            inventoryService.updateProductPrice(productId, newPrice);
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void updateReorderLevel() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("UPDATE REORDER LEVEL");
        System.out.println("-".repeat(80));

        System.out.print("Enter Product ID: ");
        int productId = getIntInput();

        Product product = inventoryService.getProduct(productId);
        if (product == null) {
            System.out.println("✗ Product not found!");
            return;
        }

        System.out.println("Current Reorder Level: " + product.getReorderLevel());
        System.out.print("Enter New Reorder Level: ");
        int newLevel = getIntInput();

        try {
            inventoryService.updateReorderLevel(productId, newLevel);
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void addStock() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("ADD STOCK");
        System.out.println("-".repeat(80));

        System.out.print("Enter Product ID: ");
        int productId = getIntInput();

        Product product = inventoryService.getProduct(productId);
        if (product == null) {
            System.out.println("✗ Product not found!");
            return;
        }

        System.out.println("Current Stock: " + product.getCurrentStock());
        System.out.print("Enter Quantity to Add: ");
        int quantity = getIntInput();

        try {
            inventoryService.addStock(productId, quantity);
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void removeStock() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("REMOVE STOCK");
        System.out.println("-".repeat(80));

        System.out.print("Enter Product ID: ");
        int productId = getIntInput();

        Product product = inventoryService.getProduct(productId);
        if (product == null) {
            System.out.println("✗ Product not found!");
            return;
        }

        System.out.println("Current Stock: " + product.getCurrentStock());
        System.out.print("Enter Quantity to Remove: ");
        int quantity = getIntInput();

        try {
            inventoryService.removeStock(productId, quantity);
        } catch (OutOfStockException e) {
            System.out.println("✗ Out of Stock Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void sendReorderAlert() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("SEND REORDER ALERT");
        System.out.println("-".repeat(80));

        inventoryService.displayLowStockItems();

        System.out.print("Enter Product ID: ");
        int productId = getIntInput();

        System.out.print("Enter Reorder Quantity: ");
        int quantity = getIntInput();

        try {
            inventoryService.sendReorderAlert(productId, quantity);
            System.out.println("✓ Reorder alert sent through all channels!");
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    // ====== UTILITY METHODS ======
    private int getIntInput() {
        try {
            int value = Integer.parseInt(scanner.nextLine().trim());
            return value;
        } catch (NumberFormatException e) {
            System.out.println("✗ Invalid input! Please enter a number.");
            return -1;
        }
    }

    private double getDoubleInput() {
        try {
            double value = Double.parseDouble(scanner.nextLine().trim());
            return value;
        } catch (NumberFormatException e) {
            System.out.println("✗ Invalid input! Please enter a valid number.");
            return 0.0;
        }
    }
}
