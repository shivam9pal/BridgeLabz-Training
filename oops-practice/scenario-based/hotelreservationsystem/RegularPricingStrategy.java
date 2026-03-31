package week02.scenario.hotelreservationsystem;

import java.time.temporal.ChronoUnit;

class RegularPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Reservation reservation) {
        long nights = ChronoUnit.DAYS.between(
                reservation.getCheckInDate(),
                reservation.getCheckOutDate()
        );
        return nights * reservation.getRoom().getBasePrice();
    }
}
