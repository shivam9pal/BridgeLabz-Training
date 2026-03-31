package week06.gcrcodebase.lambda.ecommercesprting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class CustomSorting {
	public static void main(String[] args) {
		List<Product> products=new ArrayList<Product>();
		
		products.add(new Product("Laptop", 800, 4.5, 10));
        products.add(new Product("Phone", 500, 4.8, 20));
        products.add(new Product("Headphones", 150, 4.2, 30));
        products.add(new Product("Monitor", 300, 4.6, 15));
        
        Comparator<Product> byPrice=Comparator.comparing(p->p.price);
        
        Comparator<Product> byRating= Comparator.comparing((Product p)->p.rating).reversed();
        Comparator<Product> byDiscount= Comparator.comparing((Product p)->p.discount).reversed();
        
        products.sort(byDiscount);
        products.forEach(System.out::println);
        products.sort(byPrice);
        products.forEach(System.out::println);
        products.sort(byDiscount);
        products.forEach(System.out::println);
	}
}
