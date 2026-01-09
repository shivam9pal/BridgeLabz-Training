package week3dsa.linkedlist.taskscheduler;

import java.util.Scanner;

public class TaskSchedulerSystem {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskLinkedList list = new TaskLinkedList();
        
        while (true) {
            System.out.println("\n===== Task Scheduler =====");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current & Move to Next");
            System.out.println("6. Search by Priority");
            System.out.println("7. Display All Tasks");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Task ID: ");
                    int id1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Task Name: ");
                    String name1 = sc.nextLine();
                    System.out.print("Priority: ");
                    int priority1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Due Date: ");
                    String date1 = sc.nextLine();
                    list.addAtBeginning(id1, name1, priority1, date1);
                    break;
                    
                case 2:
                    System.out.print("Task ID: ");
                    int id2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Task Name: ");
                    String name2 = sc.nextLine();
                    System.out.print("Priority: ");
                    int priority2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Due Date: ");
                    String date2 = sc.nextLine();
                    list.addAtEnd(id2, name2, priority2, date2);
                    break;
                    
                case 3:
                    System.out.print("Task ID: ");
                    int id3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Task Name: ");
                    String name3 = sc.nextLine();
                    System.out.print("Priority: ");
                    int priority3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Due Date: ");
                    String date3 = sc.nextLine();
                    System.out.print("Position: ");
                    int pos = sc.nextInt();
                    list.addAtPosition(id3, name3, priority3, date3, pos);
                    break;
                    
                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    int idDel = sc.nextInt();
                    list.removeById(idDel);
                    break;
                    
                case 5:
                    list.viewCurrentAndNext();
                    break;
                    
                case 6:
                    System.out.print("Enter priority to search: ");
                    int prioritySearch = sc.nextInt();
                    list.searchByPriority(prioritySearch);
                    break;
                    
                case 7:
                    list.displayAll();
                    break;
                    
                case 8:
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
