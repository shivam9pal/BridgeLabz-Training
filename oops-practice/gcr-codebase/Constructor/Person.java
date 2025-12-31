package week02.gcrCodebase.constructor;

public class Person {
    String name;
    int age;
    //parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //copy constructor
    Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }

    void display() {
        System.out.println(name + " - " + age);
    }

    public static void main(String[] args) {
        Person p1 = new Person("Shivam", 22);
        Person p2 = new Person(p1);
        p1.display();
        p2.display();
    }
}

