package week04.gcrcodebase.generics.smartwarehouse;

class Furniture extends WarehouseItem {
    Furniture(String name) {
        super(name);
    }

    @Override
    String getType() {
        return "Furniture";
    }
}
