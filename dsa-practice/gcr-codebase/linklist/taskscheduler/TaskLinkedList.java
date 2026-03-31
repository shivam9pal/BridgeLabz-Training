package week3dsa.linkedlist.taskscheduler;

public class TaskLinkedList {
    
    private Task head;
    private Task current; // For circular traversal
    
    public TaskLinkedList() {
        this.head = null;
        this.current = null;
    }
    
    // Add task at beginning
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        
        if (head == null) {
            head = newTask;
            newTask.next = head; // Point to itself (circular)
            current = head;
        } else {
            Task temp = head;
            // Find last node
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
            current = head;
        }
        System.out.println("✓ Added at beginning: " + taskName);
    }
    
    // Add task at end
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
        System.out.println("✓ Added at end: " + taskName);
    }
    
    // Add at position
    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position < 1) {
            System.out.println("✗ Position must be >= 1");
            return;
        }
        
        if (position == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        int count = 1;
        
        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }
        
        newTask.next = temp.next;
        temp.next = newTask;
        System.out.println("✓ Added at position " + position + ": " + taskName);
    }
    
    // Remove task by ID
    public void removeById(int taskId) {
        if (head == null) {
            System.out.println("✗ List is empty!");
            return;
        }
        
        // Single node case
        if (head.next == head && head.taskId == taskId) {
            head = null;
            current = null;
            System.out.println("✓ Removed task ID: " + taskId);
            return;
        }
        
        // Head node case
        if (head.taskId == taskId) {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
            current = head;
            System.out.println("✓ Removed task ID: " + taskId);
            return;
        }
        
        // Other nodes
        Task temp = head;
        while (temp.next != head && temp.next.taskId != taskId) {
            temp = temp.next;
        }
        
        if (temp.next == head) {
            System.out.println("✗ Task not found with ID: " + taskId);
            return;
        }
        
        temp.next = temp.next.next;
        System.out.println("✓ Removed task ID: " + taskId);
    }
    
    // View current task and move to next
    public void viewCurrentAndNext() {
        if (current == null) {
            System.out.println("✗ No tasks available!");
            return;
        }
        
        System.out.println("Current Task: " + current);
        current = current.next;
        System.out.println("Moved to next task: " + current);
    }
    
    // Search by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("✗ List is empty!");
            return;
        }
        
        Task temp = head;
        boolean found = false;
        System.out.println("\nTasks with priority " + priority + ":");
        
        do {
            if (temp.priority == priority) {
                System.out.println("  " + temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        
        if (!found) {
            System.out.println("  No tasks found");
        }
    }
    
    // Display all tasks
    public void displayAll() {
        if (head == null) {
            System.out.println("✗ No tasks in the list.");
            return;
        }
        
        System.out.println("\n=== All Tasks ===");
        Task temp = head;
        int position = 1;
        
        do {
            System.out.println(position + ". " + temp);
            temp = temp.next;
            position++;
        } while (temp != head);
        
        System.out.println("=================\n");
    }
}
