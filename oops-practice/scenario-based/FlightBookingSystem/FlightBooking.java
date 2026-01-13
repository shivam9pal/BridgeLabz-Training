package week02.scenario.FlightBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class FlightBooking {

    // Array for flights (Requirement)
    private Flight[] flights = new Flight[3];

    // List for bookings
    private List<Booking> bookings = new ArrayList<>();

    public FlightBooking() {
        flights[0] = new DirectFlight(101, "Indigo", 4500, "Delhi", "Mumbai");
        flights[1] = new ConnectingFlight(102, "Air India", 5500, "Delhi", "Chennai");
        flights[2] = new DirectFlight(103, "Vistara", 4800, "Mumbai", "Delhi");
    }

    public void showAllFlights() {
        for (Flight f : flights) {
            System.out.println(f);
        }
    }

    public Flight searchFlight(String origin, String destination)
            throws FlightNotAvailableException {

        for (Flight f : flights) {
            if (f.getOrigin().equalsIgnoreCase(origin)
                    && f.getDestination().equalsIgnoreCase(destination)) {
                return f;
            }
        }
        throw new FlightNotAvailableException("No flight found!");
    }

    public void bookFlight(User user, String origin, String destination)
            throws FlightNotAvailableException {

        Flight flight = searchFlight(origin, destination);
        Booking booking = new Booking(user, flight);

        bookings.add(booking);
        user.addBooking(booking);

        System.out.println("✅ Booking Successful!");
    }

    public void displayBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }
        for (Booking b : bookings) {
            System.out.println(b.toString());
        }
    }
}
