package week04.gcrcodebase.generics.smartwarehouse;

class Groceries extends WarehouseItem {
    Groceries(String name) {
        super(name);
    }

    @Override
    String getType() {
        return "Groceries";
    }
}
