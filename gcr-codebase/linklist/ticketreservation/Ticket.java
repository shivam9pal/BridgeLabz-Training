package week3dsa.linkedlist.ticketreservation;

// Node class for circular linked list
class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;
    
    Ticket next;
    
    public Ticket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
    
    @Override
    public String toString() {
        return String.format("Ticket ID: %d | Customer: %s | Movie: %s | Seat: %d | Time: %s", 
                            ticketId, customerName, movieName, seatNumber, bookingTime);
    }
}
