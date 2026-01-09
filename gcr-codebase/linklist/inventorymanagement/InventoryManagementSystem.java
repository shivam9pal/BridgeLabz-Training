package week3dsa.linkedlist.inventorymanagement;

import java.util.Scanner;

public class InventoryManagementSystem {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryLinkedList list = new InventoryLinkedList();
        
        while (true) {
            System.out.println("\n===== Inventory Management System =====");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search by ID");
            System.out.println("7. Search by Name");
            System.out.println("8. Calculate Total Value");
            System.out.println("9. Sort by Name");
            System.out.println("10. Sort by Price");
            System.out.println("11. Display All Items");
            System.out.println("12. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Item ID: ");
                    int id1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Item Name: ");
                    String name1 = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty1 = sc.nextInt();
                    System.out.print("Price: ");
                    double price1 = sc.nextDouble();
                    list.addAtBeginning(id1, name1, qty1, price1);
                    break;
                    
                case 2:
                    System.out.print("Item ID: ");
                    int id2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Item Name: ");
                    String name2 = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty2 = sc.nextInt();
                    System.out.print("Price: ");
                    double price2 = sc.nextDouble();
                    list.addAtEnd(id2, name2, qty2, price2);
                    break;
                    
                case 3:
                    System.out.print("Item ID: ");
                    int id3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Item Name: ");
                    String name3 = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty3 = sc.nextInt();
                    System.out.print("Price: ");
                    double price3 = sc.nextDouble();
                    System.out.print("Position: ");
                    int pos = sc.nextInt();
                    list.addAtPosition(id3, name3, qty3, price3, pos);
                    break;
                    
                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    int idDel = sc.nextInt();
                    list.removeById(idDel);
                    break;
                    
                case 5:
                    System.out.print("Enter Item ID: ");
                    int idUpdate = sc.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQty = sc.nextInt();
                    list.updateQuantity(idUpdate, newQty);
                    break;
                    
                case 6:
                    System.out.print("Enter Item ID to search: ");
                    int idSearch = sc.nextInt();
                    list.searchById(idSearch);
                    break;
                    
                case 7:
                    System.out.print("Enter Item Name to search: ");
                    String nameSearch = sc.nextLine();
                    list.searchByName(nameSearch);
                    break;
                    
                case 8:
                    list.calculateTotalValue();
                    break;
                    
                case 9:
                    System.out.print("Ascending (1) or Descending (2): ");
                    int order1 = sc.nextInt();
                    list.sortByName(order1 == 1);
                    break;
                    
                case 10:
                    System.out.print("Ascending (1) or Descending (2): ");
                    int order2 = sc.nextInt();
                    list.sortByPrice(order2 == 1);
                    break;
                    
                case 11:
                    list.displayAll();
                    break;
                    
                case 12:
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
