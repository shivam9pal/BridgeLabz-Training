package week02.scenario.ecommerceplatform;

import java.util.*;

public class Order {

    private int orderId;
    private int customerId;
    private List<Product> products;
    private List<Integer> quantities;
    private String status;
    private double totalAmount;
    private String orderDate;

    public Order(int orderId, int customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.products = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.status = "Pending";
        this.totalAmount = 0.0;
        this.orderDate = new java.time.LocalDate.now().toString();
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void addProduct(Product product, int quantity) {
        products.add(product);
        quantities.add(quantity);
        totalAmount += product.getPrice() * quantity;
    }

    public void removeProduct(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == productId) {
                totalAmount -= products.get(i).getPrice() * quantities.get(i);
                products.remove(i);
                quantities.remove(i);
                break;
            }
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId
                + " | Customer ID: " + customerId
                + " | Status: " + status
                + " | Total: Rs." + String.format("%.2f", totalAmount)
                + " | Date: " + orderDate;
    }
}
