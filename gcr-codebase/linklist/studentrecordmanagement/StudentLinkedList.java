package week3dsa.linkedlist.studentrecordmanagement;

public class StudentLinkedList {
    
    private Student head; // Points to the first student in the list
    
    public StudentLinkedList() {
        this.head = null;
    }
    
    // O(1) - Insert at beginning by updating head
    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
        System.out.println("✓ Added at beginning: " + name);
    }
    
    // O(n) - Traverse to end and insert
    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        
        if (head == null) {
            head = newStudent;
            System.out.println("✓ Added first student: " + name);
            return;
        }
        
        // Traverse to the last node
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        
        temp.next = newStudent;
        System.out.println("✓ Added at end: " + name);
    }
    
    // Insert at specific position (1-indexed)
    public void addAtPosition(int rollNumber, String name, int age, String grade, int position) {
        if (position < 1) {
            System.out.println("✗ Position must be >= 1");
            return;
        }
        
        if (position == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        
        Student newStudent = new Student(rollNumber, name, age, grade);
        
        // Navigate to the node before insertion position
        Student temp = head;
        int count = 1;
        
        while (count < position - 1 && temp != null) {
            temp = temp.next;
            count++;
        }
        
        if (temp == null) {
            System.out.println("✗ Position out of bounds!");
            return;
        }
        
        newStudent.next = temp.next;
        temp.next = newStudent;
        System.out.println("✓ Added at position " + position + ": " + name);
    }
    
    // Delete student by roll number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("✗ List is empty!");
            return;
        }
        
        if (head.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("✓ Deleted student with Roll: " + rollNumber);
            return;
        }
        
        // Find the node before the one to delete
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        
        if (temp.next == null) {
            System.out.println("✗ Student not found with Roll: " + rollNumber);
            return;
        }
        
        // Unlink the node by skipping it
        temp.next = temp.next.next;
        System.out.println("✓ Deleted student with Roll: " + rollNumber);
    }
    
    // Linear search for student by roll number
    public Student searchByRollNumber(int rollNumber) {
        Student temp = head;
        
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("✓ Student found!");
                return temp;
            }
            temp = temp.next;
        }
        
        System.out.println("✗ Student not found with Roll: " + rollNumber);
        return null;
    }
    
    // Update grade for a student
    public void updateGrade(int rollNumber, String newGrade) {
        Student student = searchByRollNumber(rollNumber);
        
        if (student != null) {
            student.grade = newGrade;
            System.out.println("✓ Updated grade to " + newGrade);
        }
    }
    
    // Display all students in the list
    public void displayAll() {
        if (head == null) {
            System.out.println("✗ No students in the list.");
            return;
        }
        
        System.out.println("\n=== All Student Records ===");
        
        Student temp = head;
        int position = 1;
        
        while (temp != null) {
            System.out.println(position + ". " + temp);
            temp = temp.next;
            position++;
        }
        
        System.out.println("===========================\n");
    }
}
