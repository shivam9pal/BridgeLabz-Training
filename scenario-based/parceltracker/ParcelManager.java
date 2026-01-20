package week03.scenariobased.parceltracker;

class ParcelManager {
	 public static void main(String[] args) {
	        ParcelTracker tracker = new ParcelTracker();

	        tracker.addStage("Packed");
	        tracker.addStage("Shipped");
	        tracker.addStage("In Transit");
	        tracker.addStage("Delivered");

	        tracker.track();

	        tracker.addAfter("Shipped", "Custom Checkpoint");
	        tracker.track();
	    }
}
