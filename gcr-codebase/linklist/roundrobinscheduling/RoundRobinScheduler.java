package week3dsa.linkedlist.roundrobinscheduling;

public class RoundRobinScheduler {
    
    private Process head;
    private Process current;
    private int timeQuantum;
    
    public RoundRobinScheduler(int timeQuantum) {
        this.head = null;
        this.current = null;
        this.timeQuantum = timeQuantum;
    }
    
    // Add process at end
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        
        if (head == null) {
            head = newProcess;
            newProcess.next = head;
            current = head;
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
        System.out.println("✓ Added process ID: " + processId);
    }
    
    // Remove process by ID after execution
    public void removeProcess(int processId) {
        if (head == null) {
            return;
        }
        
        // Single node case
        if (head.next == head && head.processId == processId) {
            head = null;
            current = null;
            return;
        }
        
        // Head node case
        if (head.processId == processId) {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
            current = head;
            return;
        }
        
        // Other nodes
        Process temp = head;
        while (temp.next != head && temp.next.processId != processId) {
            temp = temp.next;
        }
        
        if (temp.next != head) {
            if (temp.next == current) {
                current = current.next;
            }
            temp.next = temp.next.next;
        }
    }
    
    // Simulate round-robin scheduling
    public void simulate() {
        if (head == null) {
            System.out.println("✗ No processes to schedule!");
            return;
        }
        
        System.out.println("\n=== Starting Round-Robin Scheduling ===");
        System.out.println("Time Quantum: " + timeQuantum);
        
        int currentTime = 0;
        int round = 1;
        
        while (head != null) {
            System.out.println("\n--- Round " + round + " ---");
            
            Process temp = current;
            Process startProcess = current;
            boolean anyProcessExecuted = false;
            
            do {
                if (temp.remainingTime > 0) {
                    anyProcessExecuted = true;
                    
                    int executionTime = Math.min(timeQuantum, temp.remainingTime);
                    System.out.printf("Executing P%d for %d units (Remaining: %d -> %d)%n", 
                                    temp.processId, executionTime, 
                                    temp.remainingTime, temp.remainingTime - executionTime);
                    
                    temp.remainingTime -= executionTime;
                    currentTime += executionTime;
                    
                    // If process completed
                    if (temp.remainingTime == 0) {
                        temp.turnAroundTime = currentTime;
                        temp.waitingTime = temp.turnAroundTime - temp.burstTime;
                        System.out.println("  ✓ Process P" + temp.processId + " completed!");
                    }
                }
                
                temp = temp.next;
            } while (temp != startProcess);
            
            // Remove completed processes
            Process check = head;
            Process checkStart = head;
            do {
                Process next = check.next;
                if (check.remainingTime == 0) {
                    removeProcess(check.processId);
                }
                check = next;
            } while (check != checkStart && head != null);
            
            if (!anyProcessExecuted) {
                break;
            }
            
            round++;
        }
        
        System.out.println("\n=== Scheduling Complete ===\n");
    }
    
    // Display current process queue
    public void displayQueue() {
        if (head == null) {
            System.out.println("✗ Queue is empty.");
            return;
        }
        
        System.out.println("\n=== Process Queue ===");
        Process temp = head;
        int position = 1;
        
        do {
            System.out.println(position + ". " + temp);
            temp = temp.next;
            position++;
        } while (temp != head);
        
        System.out.println("=====================\n");
    }
    
    // Calculate and display statistics
    public void calculateStatistics() {
        if (head == null) {
            System.out.println("✗ No processes available!");
            return;
        }
        
        Process temp = head;
        int totalWaiting = 0;
        int totalTurnAround = 0;
        int count = 0;
        
        do {
            totalWaiting += temp.waitingTime;
            totalTurnAround += temp.turnAroundTime;
            count++;
            System.out.printf("P%d: Waiting Time = %d, Turn-Around Time = %d%n",
                            temp.processId, temp.waitingTime, temp.turnAroundTime);
            temp = temp.next;
        } while (temp != head);
        
        System.out.printf("%nAverage Waiting Time: %.2f%n", (double) totalWaiting / count);
        System.out.printf("Average Turn-Around Time: %.2f%n", (double) totalTurnAround / count);
    }
}
