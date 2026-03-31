package week3dsa.linkedlist.ticketreservation;

import java.util.Scanner;

public class TicketReservationSystem {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationList list = new TicketReservationList();
        
        while (true) {
            System.out.println("\n===== Online Ticket Reservation System =====");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Search by Customer Name");
            System.out.println("4. Search by Movie Name");
            System.out.println("5. Count Total Tickets");
            System.out.println("6. Display All Tickets");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Ticket ID: ");
                    int ticketId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Customer Name: ");
                    String customer = sc.nextLine();
                    System.out.print("Movie Name: ");
                    String movie = sc.nextLine();
                    System.out.print("Seat Number: ");
                    int seat = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Booking Time: ");
                    String time = sc.nextLine();
                    list.addTicket(ticketId, customer, movie, seat, time);
                    break;
                    
                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    int cancelId = sc.nextInt();
                    list.removeTicket(cancelId);
                    break;
                    
                case 3:
                    System.out.print("Enter customer name: ");
                    String searchCustomer = sc.nextLine();
                    list.searchByCustomer(searchCustomer);
                    break;
                    
                case 4:
                    System.out.print("Enter movie name: ");
                    String searchMovie = sc.nextLine();
                    list.searchByMovie(searchMovie);
                    break;
                    
                case 5:
                    list.countTickets();
                    break;
                    
                case 6:
                    list.displayAll();
                    break;
                    
                case 7:
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
