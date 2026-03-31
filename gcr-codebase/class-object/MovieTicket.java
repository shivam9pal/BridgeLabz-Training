package week02.gcrCodebase.classObject;

class MovieTicket {
	//Setting attributes for movie
    private String movieName;
    private String seatNumber;
    private double price;
    private boolean booked = false;
    //book ticket
    void bookTicket(String movie, String seat, double amount) {
        if (booked) {
            System.out.println("House full!!! sorry..... Ticket already booked");
        } else {
            movieName = movie;
            seatNumber = seat;
            price = amount;
            booked = true;
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
        }
    }
    //display ticket
    void displayTicket() {
        if (!booked)
            System.out.println("Ticket have not booked yet....");
        else
            System.out.println("Price: $" + price);
    }
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        ticket.displayTicket();
        ticket.bookTicket("Dragon", "A10", 120);
        ticket.bookTicket("Dragon", "A10", 120);
        ticket.displayTicket();
    }
}
