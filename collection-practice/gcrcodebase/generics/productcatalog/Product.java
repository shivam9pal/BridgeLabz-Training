package week04.gcrcodebase.generics.productcatalog;

class Product<T> {
	String productName;
	double price;
	T category;
	
	Product(String productName, double price, T category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }
	
	
	void display() {
        System.out.println(productName + " - " + price + " (" + category.getClass().getSimpleName() + ")");
    }
}
