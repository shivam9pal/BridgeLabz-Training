	package week04.gcrcodebase.generics.smartwarehouse;

import java.util.ArrayList;
import java.util.List;

//generic storage
class Storage<T extends WarehouseItem> {
	private List<T> items = new ArrayList<>();
	
	void addItem(T item) {
        items.add(item);
    }

    List<T> getItems() {
        return items;
    }

}
