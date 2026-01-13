package week02.scenario.ecommerceplatform;

import java.util.*;

public class ECommerceService {

    private Map<Integer, Product> productCatalog;
    private Map<Integer, Customer> customers;
    private Map<Integer, Order> orders;
    private Map<Integer, Delivery> deliveries;
    private int orderIdCounter = 1001;
    private int deliveryIdCounter = 5001;

    public ECommerceService() {
        this.productCatalog = new HashMap<>();
        this.customers = new HashMap<>();
        this.orders = new HashMap<>();
        this.deliveries = new HashMap<>();
        initializeProducts();
    }

    // ====== PRODUCT MANAGEMENT ======
    private void initializeProducts() {
        productCatalog.put(101, new Product(101, "Laptop", 50000, 5, "Electronics"));
        productCatalog.put(102, new Product(102, "Mobile Phone", 20000, 10, "Electronics"));
        productCatalog.put(103, new Product(103, "Headphones", 2000, 15, "Electronics"));
        productCatalog.put(104, new Product(104, "T-Shirt", 500, 20, "Clothing"));
        productCatalog.put(105, new Product(105, "Jeans", 1200, 12, "Clothing"));
        productCatalog.put(106, new Product(106, "Running Shoes", 3000, 8, "Footwear"));
        productCatalog.put(107, new Product(107, "Book - Java Programming", 600, 25, "Books"));
        productCatalog.put(108, new Product(108, "Coffee Maker", 2500, 6, "Home Appliances"));
    }

    public void displayProductCatalog() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("PRODUCT CATALOG");
        System.out.println("=".repeat(80));
        if (productCatalog.isEmpty()) {
            System.out.println("No products available!");
        } else {
            for (Product product : productCatalog.values()) {
                System.out.println(product);
            }
        }
        System.out.println("=".repeat(80));
    }

    public Product getProduct(int productId) {
        return productCatalog.get(productId);
    }

    public Collection<Product> getAllProducts() {
        return productCatalog.values();
    }

    // ====== CUSTOMER MANAGEMENT ======
    public void registerCustomer(int customerId, String name, String email, String phone, String address) {
        Customer customer = new Customer(customerId, name, email, phone, address);
        customers.put(customerId, customer);
        System.out.println("✓ Customer registered successfully!");
    }

    public Customer getCustomer(int customerId) {
        return customers.get(customerId);
    }

    public void displayCustomer(int customerId) {
        Customer customer = customers.get(customerId);
        if (customer != null) {
            System.out.println("\n" + "=".repeat(80));
            System.out.println(customer);
            System.out.println("=".repeat(80));
        } else {
            System.out.println("✗ Customer not found!");
        }
    }

    // ====== ORDER MANAGEMENT ======
    public Order createOrder(int customerId) {
        if (customers.containsKey(customerId)) {
            Order order = new Order(orderIdCounter++, customerId);
            orders.put(order.getOrderId(), order);
            System.out.println("✓ Order created! Order ID: " + order.getOrderId());
            return order;
        } else {
            System.out.println("✗ Customer not found!");
            return null;
        }
    }

    public void addProductToOrder(int orderId, int productId, int quantity) throws Exception {
        Order order = orders.get(orderId);
        Product product = productCatalog.get(productId);

        if (order == null) {
            throw new Exception("Order not found!");
        }
        if (product == null) {
            throw new Exception("Product not found!");
        }
        if (product.getStock() < quantity) {
            throw new Exception("Insufficient stock! Available: " + product.getStock());
        }

        order.addProduct(product, quantity);
        product.decreaseStock(quantity);
        System.out.println("✓ Product added to order!");
    }

    public void removeProductFromOrder(int orderId, int productId) throws Exception {
        Order order = orders.get(orderId);
        if (order == null) {
            throw new Exception("Order not found!");
        }

        for (int i = 0; i < order.getProducts().size(); i++) {
            if (order.getProducts().get(i).getProductId() == productId) {
                Product product = order.getProducts().get(i);
                int quantity = order.getQuantities().get(i);
                product.increaseStock(quantity); // Restore stock
                order.removeProduct(productId);
                System.out.println("✓ Product removed from order!");
                return;
            }
        }
        throw new Exception("Product not found in order!");
    }

    public void displayOrder(int orderId) {
        Order order = orders.get(orderId);
        if (order != null) {
            System.out.println("\n" + "=".repeat(80));
            System.out.println(order);
            System.out.println("-".repeat(80));
            System.out.println("ITEMS IN ORDER:");
            for (int i = 0; i < order.getProducts().size(); i++) {
                Product product = order.getProducts().get(i);
                int quantity = order.getQuantities().get(i);
                System.out.println("  • " + product.getProductName() + " x" + quantity + " @ Rs." + product.getPrice() + " = Rs." + (product.getPrice() * quantity));
            }
            System.out.println("-".repeat(80));
            System.out.println("TOTAL: Rs." + String.format("%.2f", order.getTotalAmount()));
            System.out.println("=".repeat(80));
        } else {
            System.out.println("✗ Order not found!");
        }
    }

    public void displayAllOrders(int customerId) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("ORDERS FOR CUSTOMER ID: " + customerId);
        System.out.println("=".repeat(80));
        boolean found = false;
        for (Order order : orders.values()) {
            if (order.getCustomerId() == customerId) {
                System.out.println(order);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No orders found for this customer!");
        }
        System.out.println("=".repeat(80));
    }

    // ====== PAYMENT PROCESSING ======
    public boolean processPayment(int orderId, Payment paymentMethod) throws PaymentFailedException {
        Order order = orders.get(orderId);
        if (order == null) {
            throw new PaymentFailedException("Order not found!");
        }

        System.out.println("\n" + "-".repeat(80));
        System.out.println("PAYMENT DETAILS:");
        System.out.println("Order ID: " + orderId);
        System.out.println("Amount: Rs." + String.format("%.2f", order.getTotalAmount()));
        System.out.println("Method: " + paymentMethod.getPaymentMethod());
        System.out.println("-".repeat(80));

        boolean success = paymentMethod.processPayment(order.getTotalAmount());
        if (success) {
            order.setStatus("Payment Confirmed");
            return true;
        }
        return false;
    }

    // ====== ORDER CANCELLATION ======
    public void cancelOrder(int orderId) throws Exception {
        Order order = orders.get(orderId);
        if (order == null) {
            throw new Exception("Order not found!");
        }

        if (order.getStatus().equals("Delivered") || order.getStatus().equals("Shipped")) {
            throw new Exception("Cannot cancel " + order.getStatus().toLowerCase() + " order!");
        }

        // Restore stock for all products
        for (int i = 0; i < order.getProducts().size(); i++) {
            Product product = order.getProducts().get(i);
            int quantity = order.getQuantities().get(i);
            product.increaseStock(quantity);
        }

        order.setStatus("Cancelled");
        System.out.println("✓ Order cancelled successfully!");
    }

    // ====== DELIVERY MANAGEMENT ======
    public void createDelivery(int orderId, String deliveryAddress, String estimatedDate) throws Exception {
        Order order = orders.get(orderId);
        if (order == null) {
            throw new Exception("Order not found!");
        }

        Delivery delivery = new Delivery(deliveryIdCounter++, orderId, deliveryAddress, estimatedDate);
        deliveries.put(delivery.getDeliveryId(), delivery);
        order.setStatus("Shipped");
        System.out.println("✓ Delivery created! Tracking Number: " + delivery.getTrackingNumber());
    }

    public void updateDeliveryStatus(int deliveryId, String newStatus) throws Exception {
        Delivery delivery = deliveries.get(deliveryId);
        if (delivery == null) {
            throw new Exception("Delivery not found!");
        }
        delivery.setStatus(newStatus);
        System.out.println("✓ Delivery status updated!");
    }

    public void trackDelivery(int deliveryId) {
        Delivery delivery = deliveries.get(deliveryId);
        if (delivery != null) {
            System.out.println("\n" + "=".repeat(80));
            System.out.println(delivery);
            System.out.println("=".repeat(80));
        } else {
            System.out.println("✗ Delivery not found!");
        }
    }

    public void displayDeliveriesForOrder(int orderId) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("DELIVERY STATUS FOR ORDER ID: " + orderId);
        System.out.println("=".repeat(80));
        boolean found = false;
        for (Delivery delivery : deliveries.values()) {
            if (delivery.getOrderId() == orderId) {
                System.out.println(delivery);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No delivery information available!");
        }
        System.out.println("=".repeat(80));
    }

    public Order getOrder(int orderId) {
        return orders.get(orderId);
    }
}
