package week04.gcrcodebase.collections.shoppingcart;

import java.util.*;

class ShoppingCart {

    // product 
    private Map<String, Double> priceMap = new HashMap<>();

    // cart items in insertion order 
    private Map<String, Integer> cart = new LinkedHashMap<>();

    // add a product to the store
    void addProduct(String name, double price) {
        priceMap.put(name, price);
    }

    // add item to cart
    void addToCart(String product, int qty) {
        if (!priceMap.containsKey(product)) {
            System.out.println("Product not found: " + product);
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + qty);
    }

    // display cart in insertion order
    void displayCart() {
        System.out.println("\nCart (Insertion Order):");
        for (String item : cart.keySet()) {
            System.out.println(item + " x " + cart.get(item) +
                    " = $" + priceMap.get(item) * cart.get(item));
        }
    }

    // display items sorted by price
    void displaySortedByPrice() {
        System.out.println("\nItems Sorted by Price:");

        // price -> List of Products
        TreeMap<Double, List<String>> sorted = new TreeMap<>();

        for (String item : cart.keySet()) {
            double price = priceMap.get(item);
            sorted.putIfAbsent(price, new ArrayList<>());
            sorted.get(price).add(item);
        }

        for (Double price : sorted.keySet()) {
            for (String item : sorted.get(price)) {
                System.out.println(item + " ($" + price + ")");
            }
        }
    }
}
