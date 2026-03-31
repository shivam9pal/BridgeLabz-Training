package week02.scenario.inventorymanagement;

public class EmailAlert implements AlertService {

    private String emailAddress;

    public EmailAlert(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void sendLowStockAlert(Product product) {
        System.out.println("\n📧 EMAIL ALERT SENT");
        System.out.println("To: " + emailAddress);
        System.out.println("Subject: Low Stock Alert - " + product.getProductName());
        System.out.println("Body: Product '" + product.getProductName() + "' (ID: " + product.getProductId()
                + ") has low stock. Current: " + product.getCurrentStock()
                + ", Reorder Level: " + product.getReorderLevel());
    }

    @Override
    public void sendOutOfStockAlert(Product product) {
        System.out.println("\n📧 EMAIL ALERT SENT");
        System.out.println("To: " + emailAddress);
        System.out.println("Subject: OUT OF STOCK ALERT - " + product.getProductName());
        System.out.println("Body: URGENT! Product '" + product.getProductName() + "' (ID: " + product.getProductId()
                + ") is OUT OF STOCK! Supplier: " + product.getSupplier());
    }

    @Override
    public void sendReorderAlert(Product product, int quantity) {
        System.out.println("\n📧 EMAIL ALERT SENT");
        System.out.println("To: " + emailAddress);
        System.out.println("Subject: Reorder Required - " + product.getProductName());
        System.out.println("Body: Please reorder " + quantity + " units of '" + product.getProductName()
                + "' from " + product.getSupplier());
    }

    @Override
    public String getAlertType() {
        return "Email";
    }
}
