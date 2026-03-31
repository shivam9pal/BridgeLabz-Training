package week02.scenario.studentcourseregistration;

import java.util.*;

public class Course {

    private int courseId;
    private String courseName;
    private String courseCode;
    private int credits;
    private String instructor;
    private int capacity;
    private List<Student> enrolledStudents;

    public Course(int courseId, String courseName, String courseCode, int credits, String instructor, int capacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
        this.instructor = instructor;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCredits() {
        return credits;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public int getAvailableSeats() {
        return capacity - enrolledStudents.size();
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }

    public boolean isAvailable() {
        return enrolledStudents.size() < capacity;
    }

    @Override
    public String toString() {
        return "Course: " + courseName
                + " (" + courseCode + ")"
                + " | ID: " + courseId
                + " | Credits: " + credits
                + " | Instructor: " + instructor
                + " | Available Seats: " + getAvailableSeats() + "/" + capacity;
    }
}
