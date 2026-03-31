package week3dsa.linkedlist.librarymanagement;

import java.util.Scanner;

public class LibraryManagementSystem {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryLinkedList list = new LibraryLinkedList();
        
        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search by Title");
            System.out.println("6. Search by Author");
            System.out.println("7. Update Availability");
            System.out.println("8. Count Total Books");
            System.out.println("9. Display Forward");
            System.out.println("10. Display Reverse");
            System.out.println("11. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Book ID: ");
                    int id1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title1 = sc.nextLine();
                    System.out.print("Author: ");
                    String author1 = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre1 = sc.nextLine();
                    System.out.print("Available (true/false): ");
                    boolean avail1 = sc.nextBoolean();
                    list.addAtBeginning(id1, title1, author1, genre1, avail1);
                    break;
                    
                case 2:
                    System.out.print("Book ID: ");
                    int id2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title2 = sc.nextLine();
                    System.out.print("Author: ");
                    String author2 = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre2 = sc.nextLine();
                    System.out.print("Available (true/false): ");
                    boolean avail2 = sc.nextBoolean();
                    list.addAtEnd(id2, title2, author2, genre2, avail2);
                    break;
                    
                case 3:
                    System.out.print("Book ID: ");
                    int id3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title3 = sc.nextLine();
                    System.out.print("Author: ");
                    String author3 = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre3 = sc.nextLine();
                    System.out.print("Available (true/false): ");
                    boolean avail3 = sc.nextBoolean();
                    System.out.print("Position: ");
                    int pos = sc.nextInt();
                    list.addAtPosition(id3, title3, author3, genre3, avail3, pos);
                    break;
                    
                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    int idDel = sc.nextInt();
                    list.removeById(idDel);
                    break;
                    
                case 5:
                    System.out.print("Enter title to search: ");
                    String titleSearch = sc.nextLine();
                    list.searchByTitle(titleSearch);
                    break;
                    
                case 6:
                    System.out.print("Enter author to search: ");
                    String authorSearch = sc.nextLine();
                    list.searchByAuthor(authorSearch);
                    break;
                    
                case 7:
                    System.out.print("Enter Book ID: ");
                    int idUpdate = sc.nextInt();
                    System.out.print("Available (true/false): ");
                    boolean availUpdate = sc.nextBoolean();
                    list.updateAvailability(idUpdate, availUpdate);
                    break;
                    
                case 8:
                    list.countBooks();
                    break;
                    
                case 9:
                    list.displayForward();
                    break;
                    
                case 10:
                    list.displayReverse();
                    break;
                    
                case 11:
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
