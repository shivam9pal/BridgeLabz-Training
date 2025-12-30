package week02.gcrCodebase.classObject;

class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    //adding item to the cart
    void addItem(int qty) {
        quantity += qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }
    //removing item from cart
    void removeItem(int qty) {
        quantity -= qty;
        System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
    }
    //displaying total cost
    void displayTotal() {
        System.out.println("Total cost: " + (price * quantity));
    }

    public static void main(String[] args) {
        CartItem item = new CartItem();
        item.itemName = "Laptop";
        item.price = 999.99;
        item.quantity = 1;

        System.out.println("Item: Laptop, Price: 999.99, Quantity: 1");
        item.addItem(2);
        item.removeItem(1);
        item.displayTotal();
    }
}
