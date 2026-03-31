package week03.scenariobased.parceltracker;

class ParcelTracker {
	private Stage head;
	
	// Add stage at end
    void addStage(String name) {
        Stage newStage = new Stage(name);

        if (head == null) {
            head = newStage;
            return;
        }

        Stage temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStage;
    }
    
    // Add intermediate checkpoint after a given stage
    void addAfter(String after, String newStageName) {
        Stage temp = head;

        while (temp != null) {
            if (temp.name.equals(after)) {
                Stage newStage = new Stage(newStageName);
                newStage.next = temp.next;
                temp.next = newStage;
                return;
            }
            temp = temp.next;
        }

        System.out.println("Stage not found: " + after);
    }
    
    // Display journey
    void track() {
        if (head == null) {
            System.out.println("Parcel is missing!");
            return;
        }

        Stage temp = head;
        System.out.print("Parcel Path: ");
        while (temp != null) {
            System.out.print(temp.name + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}
