package week03.scenariobased.trafficmanager;

class RoundAbout {
	private Vehicle head = null;

    void addVehicle(String number) {
        Vehicle newNode = new Vehicle(number);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Vehicle temp = head;
            while (temp.next != head)
                temp = temp.next;

            temp.next = newNode;
            newNode.next = head;
        }
        System.out.println(number + " entered roundabout.");
    }

    void removeVehicle(String number) {
        if (head == null) return;

        Vehicle curr = head, prev = null;

        do {
            if (curr.number.equals(number)) {
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                	// removing head
                    Vehicle last = head;
                    while (last.next != head)
                        last = last.next;

                    head = head.next;
                    last.next = head;
                }
                System.out.println(number + " exited roundabout.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    void printState() {
        if (head == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        Vehicle temp = head;
        System.out.print("Roundabout: ");
        do {
            System.out.print(temp.number + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to start)");
    }
}
