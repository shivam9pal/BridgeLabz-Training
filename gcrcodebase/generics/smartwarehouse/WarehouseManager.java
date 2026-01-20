package week04.gcrcodebase.generics.smartwarehouse;

class WarehouseManager {
	public static void main(String[] args) {

        Storage<Electronics> eStore = new Storage<>();
        Storage<Groceries> gStore = new Storage<>();
        Storage<Furniture> fStore = new Storage<>();

        eStore.addItem(new Electronics("Laptop"));
        gStore.addItem(new Groceries("Rice"));
        fStore.addItem(new Furniture("Chair"));
        WarehouseUtil.displayAll(eStore.getItems());
        WarehouseUtil.displayAll(gStore.getItems());
        WarehouseUtil.displayAll(fStore.getItems());
    }
}
