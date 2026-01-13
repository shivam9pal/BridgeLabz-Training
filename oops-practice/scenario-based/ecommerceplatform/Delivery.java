package week02.scenario.ecommerceplatform;

public class Delivery {

    private int deliveryId;
    private int orderId;
    private String status;
    private String trackingNumber;
    private String deliveryAddress;
    private String estimatedDeliveryDate;

    public Delivery(int deliveryId, int orderId, String deliveryAddress, String estimatedDeliveryDate) {
        this.deliveryId = deliveryId;
        this.orderId = orderId;
        this.deliveryAddress = deliveryAddress;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.status = "Pending";
        this.trackingNumber = "TRK" + System.currentTimeMillis();
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    @Override
    public String toString() {
        return "Delivery ID: " + deliveryId
                + " | Order ID: " + orderId
                + " | Status: " + status
                + " | Tracking: " + trackingNumber
                + " | Delivery Address: " + deliveryAddress
                + " | Est. Delivery: " + estimatedDeliveryDate;
    }
}
