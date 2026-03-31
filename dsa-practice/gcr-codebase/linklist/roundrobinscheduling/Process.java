package week3dsa.linkedlist.roundrobinscheduling;

// Node class for circular linked list
class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnAroundTime;
    
    Process next;
    
    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnAroundTime = 0;
        this.next = null;
    }
    
    @Override
    public String toString() {
        return String.format("PID: %d | Burst: %d | Remaining: %d | Priority: %d", 
                            processId, burstTime, remainingTime, priority);
    }
}
