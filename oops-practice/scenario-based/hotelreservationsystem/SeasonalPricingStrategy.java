package week02.scenario.hotelreservationsystem;

import java.time.temporal.ChronoUnit;

class SeasonalPricingStrategy implements PricingStrategy {
    private final double peakMultiplier;

    public SeasonalPricingStrategy(double peakMultiplier) {
        this.peakMultiplier = peakMultiplier;
    }

    @Override
    public double calculatePrice(Reservation reservation) {
        long nights = ChronoUnit.DAYS.between(
                reservation.getCheckInDate(),
                reservation.getCheckOutDate()
        );
        return nights * reservation.getRoom().getBasePrice() * peakMultiplier;
    }
}
