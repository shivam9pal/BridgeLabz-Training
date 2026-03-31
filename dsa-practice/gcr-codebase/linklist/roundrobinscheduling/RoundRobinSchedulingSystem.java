package week3dsa.linkedlist.roundrobinscheduling;

import java.util.Scanner;

public class RoundRobinSchedulingSystem {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Time Quantum: ");
        int timeQuantum = sc.nextInt();
        
        RoundRobinScheduler scheduler = new RoundRobinScheduler(timeQuantum);
        
        while (true) {
            System.out.println("\n===== Round-Robin CPU Scheduling =====");
            System.out.println("1. Add Process");
            System.out.println("2. Display Queue");
            System.out.println("3. Run Simulation");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Process ID: ");
                    int pid = sc.nextInt();
                    System.out.print("Burst Time: ");
                    int burst = sc.nextInt();
                    System.out.print("Priority: ");
                    int priority = sc.nextInt();
                    scheduler.addProcess(pid, burst, priority);
                    break;
                    
                case 2:
                    scheduler.displayQueue();
                    break;
                    
                case 3:
                    scheduler.simulate();
                    break;
                    
                case 4:
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
