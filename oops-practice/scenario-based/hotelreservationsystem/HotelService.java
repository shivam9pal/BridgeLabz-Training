package week02.scenario.hotelreservationsystem;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class HotelService {

    private List<Room> rooms = new ArrayList<>();
    private List<Guest> guests = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private List<Invoice> invoices = new ArrayList<>();

    private PricingStrategy pricingStrategy;

    public HotelService(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    
    //add room
    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoom(int roomNumber) {
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public List<Room> getAllRooms() {
        return rooms;
    }

    public void deleteRoom(int roomNumber) {
        Room room = getRoom(roomNumber);
        if (room != null) {
            room.deactivate(); // soft delete
        }
    }

    // -------- Guest CRUD --------

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public Guest getGuest(String id) {
        for (int i = 0; i < guests.size(); i++) {
            Guest guest = guests.get(i);
            if (guest.getId().equals(id)) {
                return guest;
            }
        }
        return null;
    }

    // -------- Reservation Flow --------

    public Reservation createReservation(String reservationId,
                                         String guestId,
                                         String roomType,
                                         LocalDate checkIn,
                                         LocalDate checkOut)
            throws RoomNotAvailableException {

        Guest guest = getGuest(guestId);
        if (guest == null) {
            guest = new Guest(guestId, "Guest-" + guestId, "");
            addGuest(guest);
        }

        Room room = findAvailableRoom(roomType, checkIn, checkOut);
        if (room == null) {
            throw new RoomNotAvailableException(
                    "No " + roomType + " room available");
        }

        Reservation reservation =
                new Reservation(reservationId, guest, room, checkIn, checkOut);
        reservations.add(reservation);

        return reservation;
    }

    public Reservation getReservation(String id) {
        for (int i = 0; i < reservations.size(); i++) {
            Reservation res = reservations.get(i);
            if (res.getId().equals(id)) {
                return res;
            }
        }
        return null;
    }

    public void updateReservationDates(String id,
                                       LocalDate newCheckIn,
                                       LocalDate newCheckOut)
            throws RoomNotAvailableException, InvalidReservationException {

        Reservation res = getReservation(id);
        if (res == null) {
            throw new InvalidReservationException("Reservation not found");
        }

        Room room = res.getRoom();
        if (!isRoomAvailable(room, newCheckIn, newCheckOut, id)) {
            throw new RoomNotAvailableException("Room not available");
        }

        res.setDates(newCheckIn, newCheckOut);
    }

    public void cancelReservation(String id)
            throws InvalidReservationException {

        Reservation res = getReservation(id);
        if (res == null) {
            throw new InvalidReservationException("Reservation not found");
        }

        res.setStatus(ReservationStatus.CANCELED);
    }

    // -------- Check-in / Check-out --------

    public void checkIn(String reservationId)
            throws InvalidReservationException {

        Reservation res = getReservation(reservationId);
        if (res == null) {
            throw new InvalidReservationException("Reservation not found");
        }

        if (res.getStatus() != ReservationStatus.BOOKED) {
            throw new InvalidReservationException("Invalid state");
        }

        res.setStatus(ReservationStatus.CHECKED_IN);
    }

    public Invoice checkOut(String reservationId)
            throws InvalidReservationException {

        Reservation res = getReservation(reservationId);
        if (res == null) {
            throw new InvalidReservationException("Reservation not found");
        }

        if (res.getStatus() != ReservationStatus.CHECKED_IN) {
            throw new InvalidReservationException("Invalid state");
        }

        double amount = pricingStrategy.calculatePrice(res);
        res.setStatus(ReservationStatus.CHECKED_OUT);

        Invoice invoice =
                new Invoice("INV-" + reservationId, res, amount);
        invoices.add(invoice);

        return invoice;
    }

    // -------- Helper Methods --------

    private Room findAvailableRoom(String roomType,
                                   LocalDate checkIn,
                                   LocalDate checkOut) {

        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);

            if (!room.isActive()) continue;
            if (!room.getType().equalsIgnoreCase(roomType)) continue;

            if (isRoomAvailable(room, checkIn, checkOut, null)) {
                return room;
            }
        }
        return null;
    }

    private boolean isRoomAvailable(Room room,
                                    LocalDate checkIn,
                                    LocalDate checkOut,
                                    String ignoreReservationId) {

        for (int i = 0; i < reservations.size(); i++) {
            Reservation res = reservations.get(i);

            if (!res.getRoom().equals(room)) continue;
            if (ignoreReservationId != null &&
                res.getId().equals(ignoreReservationId)) continue;
            if (res.getStatus() == ReservationStatus.CANCELED) continue;

            boolean overlap =
                    !(checkOut.compareTo(res.getCheckInDate()) <= 0 ||
                      checkIn.compareTo(res.getCheckOutDate()) >= 0);

            if (overlap) {
                return false;
            }
        }
        return true;
    }
}

