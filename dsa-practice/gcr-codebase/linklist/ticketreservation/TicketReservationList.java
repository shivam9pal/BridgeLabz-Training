package week3dsa.linkedlist.ticketreservation;

public class TicketReservationList {
    
    private Ticket head;
    
    public TicketReservationList() {
        this.head = null;
    }
    
    // Add ticket at end
    public void addTicket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        
        if (head == null) {
            head = newTicket;
            newTicket.next = head; // Circular
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
        System.out.println("✓ Ticket booked successfully!");
    }
    
    // Remove ticket by ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("✗ No tickets available!");
            return;
        }
        
        // Single node case
        if (head.next == head && head.ticketId == ticketId) {
            head = null;
            System.out.println("✓ Ticket cancelled: " + ticketId);
            return;
        }
        
        // Head node case
        if (head.ticketId == ticketId) {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
            System.out.println("✓ Ticket cancelled: " + ticketId);
            return;
        }
        
        // Other nodes
        Ticket temp = head;
        while (temp.next != head && temp.next.ticketId != ticketId) {
            temp = temp.next;
        }
        
        if (temp.next == head) {
            System.out.println("✗ Ticket not found with ID: " + ticketId);
            return;
        }
        
        temp.next = temp.next.next;
        System.out.println("✓ Ticket cancelled: " + ticketId);
    }
    
    // Search by customer name
    public void searchByCustomer(String customerName) {
        if (head == null) {
            System.out.println("✗ No tickets available!");
            return;
        }
        
        Ticket temp = head;
        boolean found = false;
        System.out.println("\nTickets for " + customerName + ":");
        
        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                System.out.println("  " + temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        
        if (!found) {
            System.out.println("  No tickets found");
        }
    }
    
    // Search by movie name
    public void searchByMovie(String movieName) {
        if (head == null) {
            System.out.println("✗ No tickets available!");
            return;
        }
        
        Ticket temp = head;
        boolean found = false;
        System.out.println("\nTickets for movie '" + movieName + "':");
        
        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                System.out.println("  " + temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        
        if (!found) {
            System.out.println("  No tickets found");
        }
    }
    
    // Count total tickets
    public void countTickets() {
        if (head == null) {
            System.out.println("Total tickets: 0");
            return;
        }
        
        Ticket temp = head;
        int count = 0;
        
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        
        System.out.println("Total booked tickets: " + count);
    }
    
    // Display all tickets
    public void displayAll() {
        if (head == null) {
            System.out.println("✗ No tickets booked.");
            return;
        }
        
        System.out.println("\n=== All Tickets ===");
        Ticket temp = head;
        int position = 1;
        
        do {
            System.out.println(position + ". " + temp);
            temp = temp.next;
            position++;
        } while (temp != head);
        
        System.out.println("===================\n");
    }
}
