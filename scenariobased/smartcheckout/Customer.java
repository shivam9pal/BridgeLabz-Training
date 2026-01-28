package week04.scenariobased.smartcheckout;

import java.util.List;

class Customer {
    String name;
    List<String> items;

    Customer(String name, List<String> items) {
        this.name = name;
        this.items = items;
    }
}
