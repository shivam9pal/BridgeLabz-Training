package week02.gcrCodebase.classObject;

public class Student {
	//Setting Attributes 
	private String name;
	private String rollNumber;
    private double m1;
    private double m2;
    private double m3;
    
    //Calculating grade
    char calculateGrade() {
        double avg = (m1 + m2 + m3) / 3;
        if (avg >= 75) return 'A';
        else if (avg >= 60) return 'B';
        else return 'C';
    }
    //Displaying details
    void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Student RollNumber: " + rollNumber);
        System.out.println("Student Marks:");
        System.out.println("Mark1: " + m1);
        System.out.println("Mark2: " + m2);
        System.out.println("Mark3: " + m3);
        System.out.println("Grade " + calculateGrade());
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Thamarai";
        s1.rollNumber = "ECE001";
        s1.m1 = 80; s1.m2 = 70; s1.m3 = 75;

        Student s2 = new Student();
        s2.name = "Kannan";
        s2.rollNumber = "CSC002";
        s2.m1 = 60; s2.m2 = 65; s2.m3 = 50;
        
        s1.displayDetails();
        s2.displayDetails();
    }

}
