package week02.scenario.hotelreservationsystem;

import java.time.LocalDate;

class Reservation {
    private final String id;
    private final Guest guest;
    private final Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private ReservationStatus status;

    public Reservation(String id, Guest guest, Room room,
                       LocalDate checkIn, LocalDate checkOut) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkIn;
        this.checkOutDate = checkOut;
        this.status = ReservationStatus.BOOKED;
    }

    public String getId() { return id; }
    public Guest getGuest() { return guest; }
    public Room getRoom() { return room; }
    public LocalDate getCheckInDate() { return checkInDate; }
    public LocalDate getCheckOutDate() { return checkOutDate; }
    public ReservationStatus getStatus() { return status; }

    public void setDates(LocalDate newCheckIn, LocalDate newCheckOut) {
        this.checkInDate = newCheckIn;
        this.checkOutDate = newCheckOut;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
