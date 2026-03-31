package week04.gcrcodebase.collections.queue;

class CircularBuffer {
    private int[] buffer;
    private int front = 0;
    private int rear = 0;
    private int size = 0;
    private int capacity;

    CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
    }

    // Insert element
    void add(int value) {
        buffer[rear] = value;
        rear = (rear + 1) % capacity;

        if (size < capacity) {
            size++;
        } else {
            // Buffer is full, overwrite oldest
            front = (front + 1) % capacity;
        }
    }

    // Display buffer content in order
    void display() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(buffer[index]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

class CircularBufferSimulation {
    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.add(1);
        cb.add(2);
        cb.add(3);
        cb.display();   // [1, 2, 3]

        cb.add(4);      // overwrites 1
        cb.display();   // [2, 3, 4]
    }
}

