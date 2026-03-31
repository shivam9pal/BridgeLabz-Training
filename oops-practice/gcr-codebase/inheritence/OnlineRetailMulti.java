package week02.gcrcodebase.inheritence;

// Base class
class Order {
    int orderId;
    String orderDate;

    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order Placed";
    }
}

// Subclass
class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    
    String getOrderStatus() {
        return "Order Shipped";
    }
}

// Subclass multilevel
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    
    String getOrderStatus() {
        return "Order Delivered";
    }
}


public class OnlineRetailMulti {

    public static void main(String[] args) {
        Order o1 = new Order(1001, "01-09-2025");
        Order o2 = new ShippedOrder(1002, "02-09-2025", "TRK123");
        Order o3 = new DeliveredOrder(1003, "03-09-2025", "TRK456", "05-09-2025");
        System.out.println("Order ID: " + o1.orderId + ", Status: " + o1.getOrderStatus());
        System.out.println("Order ID: " + o2.orderId + ", Status: " + o2.getOrderStatus());
        System.out.println("Order ID: " + o3.orderId + ", Status: " + o3.getOrderStatus());
    }
}
