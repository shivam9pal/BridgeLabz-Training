package week02.scenario.ecommerceplatform;

import java.util.*;

public class ECommerceApplication {

    private ECommerceService service;
    private Scanner scanner;
    private int currentCustomerId = -1;

    public ECommerceApplication() {
        this.service = new ECommerceService();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ECommerceApplication app = new ECommerceApplication();
        app.run();
    }

    public void run() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                  WELCOME TO E-COMMERCE ORDER MANAGEMENT SYSTEM                   ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");

        boolean running = true;
        while (running) {
            if (currentCustomerId == -1) {
                running = handleAuthMenu();
            } else {
                running = handleMainMenu();
            }
        }

        System.out.println("\n╔════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    Thank you for using our platform! Goodbye!                      ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
        scanner.close();
    }

    // ====== AUTHENTICATION MENU ======
    private boolean handleAuthMenu() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("AUTHENTICATION MENU");
        System.out.println("=".repeat(80));
        System.out.println("1. Register as New Customer");
        System.out.println("2. Login (Use Existing Customer ID)");
        System.out.println("3. Exit");
        System.out.println("=".repeat(80));
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                registerNewCustomer();
                break;
            case 2:
                loginCustomer();
                break;
            case 3:
                return false;
            default:
                System.out.println("✗ Invalid choice! Please try again.");
        }
        return true;
    }

    private void registerNewCustomer() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("NEW CUSTOMER REGISTRATION");
        System.out.println("-".repeat(80));

        System.out.print("Enter Customer ID: ");
        int customerId = getIntInput();

        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine().trim();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine().trim();

        service.registerCustomer(customerId, name, email, phone, address);
        currentCustomerId = customerId;
        System.out.println("✓ Welcome, " + name + "!");
    }

    private void loginCustomer() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("CUSTOMER LOGIN");
        System.out.println("-".repeat(80));

        System.out.print("Enter Customer ID: ");
        int customerId = getIntInput();

        if (service.getCustomer(customerId) != null) {
            currentCustomerId = customerId;
            System.out.println("✓ Login successful!");
        } else {
            System.out.println("✗ Customer not found! Please register first.");
        }
    }

    // ====== MAIN MENU ======
    private boolean handleMainMenu() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("MAIN MENU (Customer ID: " + currentCustomerId + ")");
        System.out.println("=".repeat(80));
        System.out.println("1. Browse Products");
        System.out.println("2. My Profile");
        System.out.println("3. Create New Order");
        System.out.println("4. View My Orders");
        System.out.println("5. Add Product to Order");
        System.out.println("6. Remove Product from Order");
        System.out.println("7. View Order Details");
        System.out.println("8. Checkout & Pay");
        System.out.println("9. Cancel Order");
        System.out.println("10. Track Delivery");
        System.out.println("11. Logout");
        System.out.println("12. Exit Application");
        System.out.println("=".repeat(80));
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                service.displayProductCatalog();
                break;
            case 2:
                service.displayCustomer(currentCustomerId);
                break;
            case 3:
                createNewOrder();
                break;
            case 4:
                service.displayAllOrders(currentCustomerId);
                break;
            case 5:
                addProductToOrder();
                break;
            case 6:
                removeProductFromOrder();
                break;
            case 7:
                viewOrderDetails();
                break;
            case 8:
                checkoutAndPay();
                break;
            case 9:
                cancelOrderMenu();
                break;
            case 10:
                trackDeliveryMenu();
                break;
            case 11:
                currentCustomerId = -1;
                System.out.println("✓ Logged out successfully!");
                break;
            case 12:
                return false;
            default:
                System.out.println("✗ Invalid choice! Please try again.");
        }
        return true;
    }

    // ====== ORDER OPERATIONS ======
    private void createNewOrder() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("CREATE NEW ORDER");
        System.out.println("-".repeat(80));

        Order order = service.createOrder(currentCustomerId);
        if (order != null) {
            // Store order ID for immediate use
            int currentOrderId = order.getOrderId();
            System.out.println("Start adding products to your order!");

            boolean addingProducts = true;
            while (addingProducts) {
                System.out.print("\nAdd more products to this order? (Y/N): ");
                String response = scanner.nextLine().trim().toUpperCase();
                if (response.equals("Y")) {
                    addProductToOrderWithId(currentOrderId);
                } else {
                    addingProducts = false;
                }
            }
        }
    }

    private void addProductToOrder() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("ADD PRODUCT TO ORDER");
        System.out.println("-".repeat(80));

        service.displayProductCatalog();

        System.out.print("Enter Order ID: ");
        int orderId = getIntInput();

        System.out.print("Enter Product ID: ");
        int productId = getIntInput();

        System.out.print("Enter Quantity: ");
        int quantity = getIntInput();

        try {
            service.addProductToOrder(orderId, productId, quantity);
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void addProductToOrderWithId(int orderId) {
        service.displayProductCatalog();

        System.out.print("Enter Product ID: ");
        int productId = getIntInput();

        System.out.print("Enter Quantity: ");
        int quantity = getIntInput();

        try {
            service.addProductToOrder(orderId, productId, quantity);
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void removeProductFromOrder() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("REMOVE PRODUCT FROM ORDER");
        System.out.println("-".repeat(80));

        System.out.print("Enter Order ID: ");
        int orderId = getIntInput();

        service.displayOrder(orderId);

        System.out.print("Enter Product ID to remove: ");
        int productId = getIntInput();

        try {
            service.removeProductFromOrder(orderId, productId);
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void viewOrderDetails() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("VIEW ORDER DETAILS");
        System.out.println("-".repeat(80));

        System.out.print("Enter Order ID: ");
        int orderId = getIntInput();

        service.displayOrder(orderId);
    }

    // ====== PAYMENT PROCESSING ======
    private void checkoutAndPay() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("CHECKOUT & PAYMENT");
        System.out.println("-".repeat(80));

        System.out.print("Enter Order ID: ");
        int orderId = getIntInput();

        Order order = service.getOrder(orderId);
        if (order == null) {
            System.out.println("✗ Order not found!");
            return;
        }

        if (order.getProducts().isEmpty()) {
            System.out.println("✗ Order is empty! Add products first.");
            return;
        }

        service.displayOrder(orderId);

        System.out.println("\n" + "-".repeat(80));
        System.out.println("SELECT PAYMENT METHOD");
        System.out.println("-".repeat(80));
        System.out.println("1. Credit/Debit Card");
        System.out.println("2. UPI");
        System.out.println("3. Digital Wallet");
        System.out.println("4. Cancel");
        System.out.print("Enter choice: ");

        int paymentChoice = getIntInput();

        try {
            Payment paymentMethod = null;
            switch (paymentChoice) {
                case 1:
                    paymentMethod = getCardPaymentDetails();
                    break;
                case 2:
                    paymentMethod = getUPIPaymentDetails();
                    break;
                case 3:
                    paymentMethod = getWalletPaymentDetails();
                    break;
                case 4:
                    System.out.println("✓ Payment cancelled!");
                    return;
                default:
                    System.out.println("✗ Invalid choice!");
                    return;
            }

            if (paymentMethod != null && service.processPayment(orderId, paymentMethod)) {
                System.out.println("\n✓ Payment successful!");

                // Create delivery
                System.out.println("\n" + "-".repeat(80));
                System.out.println("DELIVERY INFORMATION");
                System.out.println("-".repeat(80));
                System.out.print("Confirm delivery address: ");
                String deliveryAddress = scanner.nextLine().trim();

                System.out.print("Estimated delivery date (YYYY-MM-DD): ");
                String estimatedDate = scanner.nextLine().trim();

                service.createDelivery(orderId, deliveryAddress, estimatedDate);
                service.displayDeliveriesForOrder(orderId);
            }
        } catch (PaymentFailedException e) {
            System.out.println("✗ Payment failed: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private Payment getCardPaymentDetails() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("CARD PAYMENT DETAILS");
        System.out.println("-".repeat(80));

        System.out.print("Enter Card Number: ");
        String cardNumber = scanner.nextLine().trim();

        System.out.print("Enter Card Holder Name: ");
        String cardHolder = scanner.nextLine().trim();

        System.out.print("Enter Expiry Date (MM/YY): ");
        String expiryDate = scanner.nextLine().trim();

        System.out.print("Enter CVV: ");
        String cvv = scanner.nextLine().trim();

        return new CardPayment(cardNumber, cardHolder, expiryDate, cvv);
    }

    private Payment getUPIPaymentDetails() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("UPI PAYMENT DETAILS");
        System.out.println("-".repeat(80));

        System.out.print("Enter UPI ID (e.g., user@bank): ");
        String upiId = scanner.nextLine().trim();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine().trim();

        return new UPIPayment(upiId, phoneNumber);
    }

    private Payment getWalletPaymentDetails() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("DIGITAL WALLET PAYMENT");
        System.out.println("-".repeat(80));

        System.out.print("Enter Wallet ID: ");
        String walletId = scanner.nextLine().trim();

        System.out.print("Enter Wallet Balance (for demo): Rs.");
        double balance = getDoubleInput();

        return new WalletPayment(walletId, balance);
    }

    // ====== ORDER CANCELLATION ======
    private void cancelOrderMenu() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("CANCEL ORDER");
        System.out.println("-".repeat(80));

        service.displayAllOrders(currentCustomerId);

        System.out.print("Enter Order ID to cancel: ");
        int orderId = getIntInput();

        try {
            service.cancelOrder(orderId);
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    // ====== DELIVERY TRACKING ======
    private void trackDeliveryMenu() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("TRACK DELIVERY");
        System.out.println("-".repeat(80));

        service.displayAllOrders(currentCustomerId);

        System.out.print("Enter Order ID: ");
        int orderId = getIntInput();

        service.displayDeliveriesForOrder(orderId);
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
