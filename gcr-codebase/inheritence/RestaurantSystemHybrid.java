package week02.gcrcodebase.inheritence;

// Interface
interface Worker {
    void performDuties();
}

// Superclass
class Persons {
    String name;
    int id;

    Persons(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

// Chef subclass
class Chef extends Persons implements Worker {

    Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Chef -> Name: " + name + ", ID: " + id + ", Duty: Cooking food");
    }
}

// subclass
class Waiter extends Persons implements Worker {
    Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter -> Name: " + name + ", ID: " + id + ", Duty: Serving customers");
    }
}

// Main class
public class RestaurantSystemHybrid {
    public static void main(String[] args) {
        Worker w1 = new Chef("Ramesh", 101);
        Worker w2 = new Waiter("Suresh", 102);

        w1.performDuties();
        w2.performDuties();
    }
}
