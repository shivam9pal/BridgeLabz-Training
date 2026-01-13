package week02.scenario.inventorymanagement;

public interface AlertService {

    void sendLowStockAlert(Product product);

    void sendOutOfStockAlert(Product product);

    void sendReorderAlert(Product product, int quantity);

    String getAlertType();
}
