package week04.scenariobased.packagee;

public class Packageimpl {
    public static void main(String[] args) {

        ParcelTracker tracker = new ParcelTracker();

        tracker.addStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("In Transit");
        tracker.addStage("Delivered");

        tracker.track();

        // Add custom checkpoint
        tracker.addAfter("Shipped", "At Warehouse");

        tracker.track();
    }
}

