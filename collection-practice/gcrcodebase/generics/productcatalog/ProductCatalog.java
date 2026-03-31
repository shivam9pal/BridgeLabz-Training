package week04.gcrcodebase.generics.productcatalog;

import java.util.ArrayList;
import java.util.List;

class ProductCatalog {
	private List<Product<?>> catalog = new ArrayList<>();
	
	void addProduct(Product<?> p) {
        catalog.add(p);
    }

    void showAll() {
        for (Product<?> p : catalog) {
            p.display();
        }
    }

    // generic Discount Method
    static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discount = product.price * (percentage / 100);
        product.price -= discount;
    }
}
