package week02.scenario.hotelreservationsystem;

class DeluxeRoom extends Room {
    public DeluxeRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    

	@Override
    public String getType() { return "Deluxe"; }
}
