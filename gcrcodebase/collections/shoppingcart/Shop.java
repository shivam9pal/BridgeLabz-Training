package week04.gcrcodebase.collections.shoppingcart;

class Shop {
	public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        // add products
        cart.addProduct("Apple", 1.5);
        cart.addProduct("Banana", 0.8);
        cart.addProduct("Milk", 2.2);
        cart.addProduct("Bread", 1.2);

        // add to cart
        cart.addToCart("Apple", 2);
        cart.addToCart("Milk", 1);
        cart.addToCart("Banana", 5);
        cart.addToCart("Bread", 1);

        // display
        cart.displayCart();
        cart.displaySortedByPrice();
    }
}
