package week3dsa.linkedlist.studentrecordmanagement;

// Node class representing a student in the linked list
class Student {

	int rollNo;
	String name;
	char grade;
	int age;
	
	Student next; // Pointer to the next student in the list
	
	public Student(int rollNo, String name, char grade, int age) {
		this.rollNo = rollNo;
		this.name = name;
		this.grade = grade;
		this.age = age;
		this.next = null;
	}
	
	@Override
	public String toString() {
		return String.format("Roll No.: %d | name: %s | age: %d | grade: %c", rollNo, name, age, grade);
	}
}
