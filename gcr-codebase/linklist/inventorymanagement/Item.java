package week3dsa.linkedlist.inventorymanagement;

// Node class for inventory item
class Item {
    int itemId;
    String itemName;
    int quantity;
    double price;
    
    Item next;
    
    public Item(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
    
    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Qty: %d | Price: $%.2f | Value: $%.2f", 
                            itemId, itemName, quantity, price, quantity * price);
    }
}
