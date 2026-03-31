package week3dsa.linkedlist.taskscheduler;

// Node class for circular linked list
class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    
    Task next; // Points to next task (circular)
    
    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
    
    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Priority: %d | Due: %s", 
                            taskId, taskName, priority, dueDate);
    }
}
