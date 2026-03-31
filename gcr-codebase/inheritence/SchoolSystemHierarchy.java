package week02.gcrcodebase.inheritence;

// Superclass
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayRole() {
        System.out.println("Person in school");
    }
}

// Teacher subclass
class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    void displayRole() {
        System.out.println("Teacher -> Name: " + name + ", Age: " + age + ", Subject: " + subject);
    }
}

// Student subclass
class Student extends Person {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    void displayRole() {
        System.out.println("Student -> Name: " + name + ", Age: " + age + ", Grade: " + grade);
    }
}

// Staff subclass
class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    void displayRole() {
        System.out.println("Staff -> Name: " + name + ", Age: " + age + ", Department: " + department);
    }
}

// Main class
public class SchoolSystemHierarchy {

    public static void main(String[] args) {

        Person p1 = new Teacher("Mr. Sharma", 40, "Mathematics");
        Person p2 = new Student("Amit", 16, "10th Grade");
        Person p3 = new Staff("Ramesh", 35, "Administration");

        p1.displayRole();
        p2.displayRole();
        p3.displayRole();
    }
}
