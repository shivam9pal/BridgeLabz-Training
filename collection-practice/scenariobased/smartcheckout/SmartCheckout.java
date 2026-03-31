package week04.scenariobased.smartcheckout;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SmartCheckout {

    // Queue for customers
    static Queue<Customer> queue = new LinkedList<>();

    // Item -> Price map
    static Map<String, Integer> priceMap = new HashMap<>();

    // Add customer to queue
    static void addCustomer(Customer c) {
        queue.add(c);
        System.out.println(c.name + " added to queue.");
    }

    // Process next customer
    static void serveCustomer() {
        if (queue.isEmpty()) {
            System.out.println("No customers in queue.");
            return;
        }

        Customer c = queue.remove();
        int total = 0;

        System.out.println("\nServing: " + c.name);
        for (String item : c.items) {
            int price = priceMap.getOrDefault(item, 0);
            System.out.println(item + " = " + price);
            total += price;
        }

        System.out.println("Total Bill: " + total);
    }

    public static void main(String[] args) {

        // Add items and prices
        priceMap.put("Milk", 40);
        priceMap.put("Bread", 30);
        priceMap.put("Apple", 10);
        priceMap.put("Rice", 60);

        // Create customers
        Customer c1 = new Customer("Harish", Arrays.asList("Milk", "Apple"));
        Customer c2 = new Customer("Boby", Arrays.asList("Bread", "Rice", "Apple"));

        // Add customers to queue
        addCustomer(c1);
        addCustomer(c2);

        // Serve customers
        serveCustomer();
        serveCustomer();
    }
}
