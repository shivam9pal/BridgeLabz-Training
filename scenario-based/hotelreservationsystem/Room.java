package week02.scenario.hotelreservationsystem;

abstract class Room {
    private final int roomNumber;
    private final double basePrice;
    private boolean active = true; // for soft-delete

    public Room(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
    }

    public int getRoomNumber() { return roomNumber; }
    public double getBasePrice() { return basePrice; }
    public boolean isActive() { return active; }
    public void deactivate() { this.active = false; }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() + " #" + roomNumber;
    }
}
