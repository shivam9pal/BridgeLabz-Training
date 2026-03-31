package week02.scenario.hotelreservationsystem;

interface PricingStrategy {
    double calculatePrice(Reservation reservation);
}
