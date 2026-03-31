package week3dsa.linkedlist.studentrecordmanagement;
import java.util.Scanner;

public class StudentManagementSystem {
    
    // Main method - Menu-driven interface
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        
        while (true) {
            System.out.println("\n===== Student Record Management =====");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Update Student Grade");
            System.out.println("7. Display All Students");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Roll Number: ");
                    int roll1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name1 = sc.nextLine();
                    System.out.print("Age: ");
                    int age1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Grade: ");
                    String grade1 = sc.nextLine();
                    
                    list.addAtBeginning(roll1, name1, age1, grade1);
                    break;
                    
                case 2:
                    System.out.print("Roll Number: ");
                    int roll2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name2 = sc.nextLine();
                    System.out.print("Age: ");
                    int age2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Grade: ");
                    String grade2 = sc.nextLine();
                    
                    list.addAtEnd(roll2, name2, age2, grade2);
                    break;
                    
                case 3:
                    System.out.print("Roll Number: ");
                    int roll3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name3 = sc.nextLine();
                    System.out.print("Age: ");
                    int age3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Grade: ");
                    String grade3 = sc.nextLine();
                    System.out.print("Position: ");
                    int pos = sc.nextInt();
                    
                    list.addAtPosition(roll3, name3, age3, grade3, pos);
                    break;
                    
                case 4:
                    System.out.print("Enter Roll Number to delete: ");
                    int rollDel = sc.nextInt();
                    list.deleteByRollNumber(rollDel);
                    break;
                    
                case 5:
                    System.out.print("Enter Roll Number to search: ");
                    int rollSearch = sc.nextInt();
                    Student found = list.searchByRollNumber(rollSearch);
                    if (found != null) {
                        System.out.println(found);
                    }
                    break;
                    
                case 6:
                    System.out.print("Enter Roll Number: ");
                    int rollUpdate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Grade: ");
                    String newGrade = sc.nextLine();
                    list.updateGrade(rollUpdate, newGrade);
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
