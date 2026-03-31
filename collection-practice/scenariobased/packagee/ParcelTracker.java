package week04.scenariobased.packagee;

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

    // Insert checkpoint after a given stage
    void addAfter(String afterStage, String newStage) {
        Stage temp = head;

        while (temp != null && !temp.name.equals(afterStage)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Stage not found: " + afterStage);
            return;
        }

        Stage node = new Stage(newStage);
        node.next = temp.next;
        temp.next = node;
    }

    // Track parcel forward
    void track() {
        if (head == null) {
            System.out.println("Parcel data missing!");
            return;
        }

        Stage temp = head;
        System.out.println("Parcel Journey:");
        while (temp != null) {
            System.out.print(temp.name);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
