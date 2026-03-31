package week3dsa.linkedlist.moviemanagement;

import java.util.Scanner;

public class MovieManagementSystem {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieLinkedList list = new MovieLinkedList();
        
        while (true) {
            System.out.println("\n===== Movie Management System =====");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Update Rating");
            System.out.println("8. Display Forward");
            System.out.println("9. Display Reverse");
            System.out.println("10. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title1 = sc.nextLine();
                    System.out.print("Director: ");
                    String director1 = sc.nextLine();
                    System.out.print("Year: ");
                    int year1 = sc.nextInt();
                    System.out.print("Rating: ");
                    double rating1 = sc.nextDouble();
                    list.addAtBeginning(title1, director1, year1, rating1);
                    break;
                    
                case 2:
                    System.out.print("Title: ");
                    String title2 = sc.nextLine();
                    System.out.print("Director: ");
                    String director2 = sc.nextLine();
                    System.out.print("Year: ");
                    int year2 = sc.nextInt();
                    System.out.print("Rating: ");
                    double rating2 = sc.nextDouble();
                    list.addAtEnd(title2, director2, year2, rating2);
                    break;
                    
                case 3:
                    System.out.print("Title: ");
                    String title3 = sc.nextLine();
                    System.out.print("Director: ");
                    String director3 = sc.nextLine();
                    System.out.print("Year: ");
                    int year3 = sc.nextInt();
                    System.out.print("Rating: ");
                    double rating3 = sc.nextDouble();
                    System.out.print("Position: ");
                    int pos = sc.nextInt();
                    list.addAtPosition(title3, director3, year3, rating3, pos);
                    break;
                    
                case 4:
                    System.out.print("Enter title to remove: ");
                    String titleDel = sc.nextLine();
                    list.removeByTitle(titleDel);
                    break;
                    
                case 5:
                    System.out.print("Enter director name: ");
                    String dirSearch = sc.nextLine();
                    list.searchByDirector(dirSearch);
                    break;
                    
                case 6:
                    System.out.print("Enter rating: ");
                    double ratingSearch = sc.nextDouble();
                    list.searchByRating(ratingSearch);
                    break;
                    
                case 7:
                    System.out.print("Enter movie title: ");
                    String titleUpdate = sc.nextLine();
                    System.out.print("Enter new rating: ");
                    double newRating = sc.nextDouble();
                    list.updateRating(titleUpdate, newRating);
                    break;
                    
                case 8:
                    list.displayForward();
                    break;
                    
                case 9:
                    list.displayReverse();
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
