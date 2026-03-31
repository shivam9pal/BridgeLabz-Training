package week04.gcrcodebase.generics.productcatalog;

class Market {
	public static void main(String[] args) {

        Product<BookCategory> b1 =
                new Product<>("Java Book", 500, new BookCategory("Education"));

        Product<ClothingCategory> c1 =
                new Product<>("T-Shirt", 1000, new ClothingCategory("Men"));

        Product<GadgetCategory> g1 =
                new Product<>("Smart Watch", 3000, new GadgetCategory("Electronics"));

        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(b1);
        catalog.addProduct(c1);
        catalog.addProduct(g1);

        ProductCatalog.applyDiscount(b1, 10);
        ProductCatalog.applyDiscount(c1, 20);

        catalog.showAll();
    }
}
