package week04.gcrcodebase.generics.smartwarehouse;

import java.util.List;

//wildcard
class WarehouseUtil {
	static void displayAll(List<? extends WarehouseItem> list) {
        for (WarehouseItem w : list) {
            System.out.println(w.getType() + " : " + w.name);
        }
    }
}
