package week02.scenario.inventorymanagement;

public class SystemAlert implements AlertService {

    private String systemName;

    public SystemAlert(String systemName) {
        this.systemName = systemName;
    }

    @Override
    public void sendLowStockAlert(Product product) {
        System.out.println("\n⚠️  SYSTEM ALERT (Dashboard)");
        System.out.println("System: " + systemName);
        System.out.println("Alert Type: Low Stock");
        System.out.println("Product: " + product.getProductName() + " (ID: " + product.getProductId() + ")");
        System.out.println("Current Stock: " + product.getCurrentStock()
                + " | Reorder Level: " + product.getReorderLevel());
    }

    @Override
    public void sendOutOfStockAlert(Product product) {
        System.out.println("\n🚨 CRITICAL SYSTEM ALERT (Dashboard)");
        System.out.println("System: " + systemName);
        System.out.println("Alert Type: OUT OF STOCK");
        System.out.println("Product: " + product.getProductName() + " (ID: " + product.getProductId() + ")");
        System.out.println("Status: INVENTORY DEPLETED");
    }

    @Override
    public void sendReorderAlert(Product product, int quantity) {
        System.out.println("\n📋 SYSTEM ALERT (Dashboard)");
        System.out.println("System: " + systemName);
        System.out.println("Alert Type: Reorder Required");
        System.out.println("Product: " + product.getProductName());
        System.out.println("Quantity Needed: " + quantity + " | Supplier: " + product.getSupplier());
    }

    @Override
    public String getAlertType() {
        return "System";
    }
}
