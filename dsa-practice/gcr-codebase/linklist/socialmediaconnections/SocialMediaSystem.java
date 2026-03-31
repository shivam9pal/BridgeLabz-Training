package week3dsa.linkedlist.socialmediaconnections;

import java.util.Scanner;

public class SocialMediaSystem {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMediaLinkedList list = new SocialMediaLinkedList();
        
        while (true) {
            System.out.println("\n===== Social Media Friend Connections =====");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display User's Friends");
            System.out.println("6. Search by Name");
            System.out.println("7. Search by ID");
            System.out.println("8. Count Friends");
            System.out.println("9. Display All Users");
            System.out.println("10. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("User ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    list.addUser(userId, name, age);
                    break;
                    
                case 2:
                    System.out.print("User ID 1: ");
                    int id1 = sc.nextInt();
                    System.out.print("User ID 2: ");
                    int id2 = sc.nextInt();
                    list.addFriendConnection(id1, id2);
                    break;
                    
                case 3:
                    System.out.print("User ID 1: ");
                    int rid1 = sc.nextInt();
                    System.out.print("User ID 2: ");
                    int rid2 = sc.nextInt();
                    list.removeFriendConnection(rid1, rid2);
                    break;
                    
                case 4:
                    System.out.print("User ID 1: ");
                    int mid1 = sc.nextInt();
                    System.out.print("User ID 2: ");
                    int mid2 = sc.nextInt();
                    list.findMutualFriends(mid1, mid2);
                    break;
                    
                case 5:
                    System.out.print("Enter User ID: ");
                    int displayId = sc.nextInt();
                    list.displayFriends(displayId);
                    break;
                    
                case 6:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    list.searchByName(searchName);
                    break;
                    
                case 7:
                    System.out.print("Enter User ID to search: ");
                    int searchId = sc.nextInt();
                    list.searchById(searchId);
                    break;
                    
                case 8:
                    System.out.print("Enter User ID: ");
                    int countId = sc.nextInt();
                    list.countFriends(countId);
                    break;
                    
                case 9:
                    list.displayAllUsers();
                    break;
                    
                case 10:
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
