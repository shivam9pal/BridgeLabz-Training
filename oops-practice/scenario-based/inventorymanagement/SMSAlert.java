package week02.scenario.inventorymanagement;

public class SMSAlert implements AlertService {

    private String phoneNumber;

    public SMSAlert(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void sendLowStockAlert(Product product) {
        System.out.println("\n📱 SMS ALERT SENT");
        System.out.println("To: " + phoneNumber);
        System.out.println("Message: Low stock alert! '" + product.getProductName()
                + "' current stock: " + product.getCurrentStock());
    }

    @Override
    public void sendOutOfStockAlert(Product product) {
        System.out.println("\n📱 SMS ALERT SENT");
        System.out.println("To: " + phoneNumber);
        System.out.println("Message: URGENT! '" + product.getProductName() + "' is OUT OF STOCK!");
    }

    @Override
    public void sendReorderAlert(Product product, int quantity) {
        System.out.println("\n📱 SMS ALERT SENT");
        System.out.println("To: " + phoneNumber);
        System.out.println("Message: Reorder " + quantity + " units of '" + product.getProductName()
                + "' from " + product.getSupplier());
    }

    @Override
    public String getAlertType() {
        return "SMS";
    }
}
