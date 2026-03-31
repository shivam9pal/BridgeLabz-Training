package week02.scenario;

import java.util.Scanner;

public class CafetariaMenuApp {
	
	static String[] menuItems = {"Tea", "Coffee", "Sandwich", "Burger", "Pizza","Pasta", "Momos", "Samosa", "Juice", "Ice Cream"};
	
	// display menu
    public static void displayMenu() {
        System.out.println("-- Cafeteria Menu");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(i + " : " + menuItems[i]);
        }
    }

 // get item by index
    public static String getItemByIndex(int index) {
        if (index < 0 || index >= menuItems.length) {
            return "Invalid item index!";
        }
        return menuItems[index];
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		displayMenu();
        System.out.print("Select item index: ");
        int choice = sc.nextInt();
        
        String selectedItem = getItemByIndex(choice);
        System.out.println("You selected: " + selectedItem);

        sc.close();

	}

}
