package week02.scenario.hotelreservationsystem;

class StandardRoom extends Room {
    public StandardRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public String getType() { return "Standard"; }
}