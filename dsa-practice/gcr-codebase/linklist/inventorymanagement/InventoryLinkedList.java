package week3dsa.linkedlist.inventorymanagement;

public class InventoryLinkedList {
    
    private Item head;
    
    public InventoryLinkedList() {
        this.head = null;
    }
    
    // Add item at beginning
    public void addAtBeginning(int itemId, String itemName, int quantity, double price) {
        Item newItem = new Item(itemId, itemName, quantity, price);
        newItem.next = head;
        head = newItem;
        System.out.println("✓ Added at beginning: " + itemName);
    }
    
    // Add item at end
    public void addAtEnd(int itemId, String itemName, int quantity, double price) {
        Item newItem = new Item(itemId, itemName, quantity, price);
        
        if (head == null) {
            head = newItem;
            System.out.println("✓ Added first item: " + itemName);
            return;
        }
        
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
        System.out.println("✓ Added at end: " + itemName);
    }
    
    // Add at position
    public void addAtPosition(int itemId, String itemName, int quantity, double price, int position) {
        if (position < 1) {
            System.out.println("✗ Position must be >= 1");
            return;
        }
        
        if (position == 1) {
            addAtBeginning(itemId, itemName, quantity, price);
            return;
        }
        
        Item newItem = new Item(itemId, itemName, quantity, price);
        Item temp = head;
        int count = 1;
        
        while (count < position - 1 && temp != null) {
            temp = temp.next;
            count++;
        }
        
        if (temp == null) {
            System.out.println("✗ Position out of bounds!");
            return;
        }
        
        newItem.next = temp.next;
        temp.next = newItem;
        System.out.println("✓ Added at position " + position + ": " + itemName);
    }
    
    // Remove by item ID
    public void removeById(int itemId) {
        if (head == null) {
            System.out.println("✗ List is empty!");
            return;
        }
        
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("✓ Removed item ID: " + itemId);
            return;
        }
        
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        
        if (temp.next == null) {
            System.out.println("✗ Item not found with ID: " + itemId);
            return;
        }
        
        temp.next = temp.next.next;
        System.out.println("✓ Removed item ID: " + itemId);
    }
    
    // Update quantity by ID
    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        
        while (temp != null && temp.itemId != itemId) {
            temp = temp.next;
        }
        
        if (temp != null) {
            temp.quantity = newQuantity;
            System.out.println("✓ Updated quantity for ID " + itemId + " to " + newQuantity);
        } else {
            System.out.println("✗ Item not found with ID: " + itemId);
        }
    }
    
    // Search by ID
    public void searchById(int itemId) {
        Item temp = head;
        
        while (temp != null && temp.itemId != itemId) {
            temp = temp.next;
        }
        
        if (temp != null) {
            System.out.println("✓ Item found: " + temp);
        } else {
            System.out.println("✗ Item not found with ID: " + itemId);
        }
    }
    
    // Search by name
    public void searchByName(String itemName) {
        if (head == null) {
            System.out.println("✗ List is empty!");
            return;
        }
        
        Item temp = head;
        boolean found = false;
        System.out.println("\nItems matching '" + itemName + "':");
        
        while (temp != null) {
            if (temp.itemName.toLowerCase().contains(itemName.toLowerCase())) {
                System.out.println("  " + temp);
                found = true;
            }
            temp = temp.next;
        }
        
        if (!found) {
            System.out.println("  No items found");
        }
    }
    
    // Calculate total inventory value
    public void calculateTotalValue() {
        if (head == null) {
            System.out.println("✗ List is empty!");
            return;
        }
        
        double totalValue = 0;
        Item temp = head;
        
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        
        System.out.printf("Total Inventory Value: $%.2f%n", totalValue);
    }
    
    // Sort by name (ascending)
    public void sortByName(boolean ascending) {
        if (head == null || head.next == null) {
            System.out.println("Not enough items to sort");
            return;
        }
        
        // Bubble sort
        boolean swapped;
        do {
            swapped = false;
            Item current = head;
            
            while (current.next != null) {
                boolean condition = ascending ? 
                    current.itemName.compareToIgnoreCase(current.next.itemName) > 0 :
                    current.itemName.compareToIgnoreCase(current.next.itemName) < 0;
                
                if (condition) {
                    swapData(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        
        System.out.println("✓ Sorted by name (" + (ascending ? "ascending" : "descending") + ")");
    }
    
    // Sort by price
    public void sortByPrice(boolean ascending) {
        if (head == null || head.next == null) {
            System.out.println("Not enough items to sort");
            return;
        }
        
        boolean swapped;
        do {
            swapped = false;
            Item current = head;
            
            while (current.next != null) {
                boolean condition = ascending ? 
                    current.price > current.next.price :
                    current.price < current.next.price;
                
                if (condition) {
                    swapData(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        
        System.out.println("✓ Sorted by price (" + (ascending ? "ascending" : "descending") + ")");
    }
    
    // Helper method to swap node data
    private void swapData(Item a, Item b) {
        int tempId = a.itemId;
        String tempName = a.itemName;
        int tempQty = a.quantity;
        double tempPrice = a.price;
        
        a.itemId = b.itemId;
        a.itemName = b.itemName;
        a.quantity = b.quantity;
        a.price = b.price;
        
        b.itemId = tempId;
        b.itemName = tempName;
        b.quantity = tempQty;
        b.price = tempPrice;
    }
    
    // Display all items
    public void displayAll() {
        if (head == null) {
            System.out.println("✗ No items in inventory.");
            return;
        }
        
        System.out.println("\n=== Inventory ===");
        Item temp = head;
        int position = 1;
        
        while (temp != null) {
            System.out.println(position + ". " + temp);
            temp = temp.next;
            position++;
        }
        System.out.println("=================\n");
    }
}
