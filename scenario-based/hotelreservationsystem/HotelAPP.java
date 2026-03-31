package week02.scenario.hotelreservationsystem;

import java.time.LocalDate;
import java.util.Scanner;

public class HotelAPP {
    public static void main(String[] args) throws Exception {
        PricingStrategy pricing = new SeasonalPricingStrategy(1.2);
        HotelService hotel = new HotelService(pricing);

        // Room setup
        hotel.addRoom(new StandardRoom(101, 2000));
        hotel.addRoom(new StandardRoom(102, 2000));
        hotel.addRoom(new DeluxeRoom(201, 3500));

        // Create reservation
        Reservation r1 = hotel.createReservation(
                "R1", "G1", "Standard",
                LocalDate.of(2026, 1, 12),
                LocalDate.of(2026, 1, 15)
        );

        // Check-in
        hotel.checkIn("R1");

        // Check-out + invoice
        Invoice invoice = hotel.checkOut("R1");
        System.out.println(invoice);
    }
}

