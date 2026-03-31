package week02.scenario.hotelreservationsystem;

class Invoice {
    private final String id;
    private final Reservation reservation;
    private final double totalAmount;

    public Invoice(String id, Reservation reservation, double totalAmount) {
        this.id = id;
        this.reservation = reservation;
        this.totalAmount = totalAmount;
    }

    public String getId() { return id; }
    public double getTotalAmount() { return totalAmount; }

    @Override
    public String toString() {
        return "Invoice #" + id + " | Reservation: " + reservation.getId()
                + " | Amount: " + totalAmount;
    }
}
