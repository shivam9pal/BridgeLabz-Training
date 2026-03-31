package week02.scenario.studentcourseregistration;

import java.util.*;

public class Student extends Person {

    private String studentId;
    private String department;
    private int semester;
    private List<Course> enrolledCourses;
    private List<Double> grades;
    private static final int MAX_COURSES = 6;

    public Student(int personId, String name, String email, String phone, String studentId, String department, int semester) {
        super(personId, name, email, phone);
        this.studentId = studentId;
        this.department = department;
        this.semester = semester;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getDepartment() {
        return department;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void enrollCourse(Course course) throws CourseLimitExceededException {
        if (enrolledCourses.size() >= MAX_COURSES) {
            throw new CourseLimitExceededException("Maximum course limit (" + MAX_COURSES + ") reached!");
        }

        for (Course c : enrolledCourses) {
            if (c.getCourseId() == course.getCourseId()) {
                throw new IllegalArgumentException("Already enrolled in this course!");
            }
        }

        enrolledCourses.add(course);
        grades.add(0.0);
        course.addStudent(this);
        System.out.println("✓ Successfully enrolled in " + course.getCourseName());
    }

    public void dropCourse(int courseId) throws Exception {
        for (int i = 0; i < enrolledCourses.size(); i++) {
            if (enrolledCourses.get(i).getCourseId() == courseId) {
                Course course = enrolledCourses.get(i);

                // Check if grade is assigned
                if (grades.get(i) > 0) {
                    throw new Exception("Cannot drop course with assigned grade!");
                }

                enrolledCourses.remove(i);
                grades.remove(i);
                course.removeStudent(this);
                System.out.println("✓ Successfully dropped from " + course.getCourseName());
                return;
            }
        }
        throw new Exception("Course not found in enrolled courses!");
    }

    public void assignGrade(int courseId, double grade) throws Exception {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100!");
        }

        for (int i = 0; i < enrolledCourses.size(); i++) {
            if (enrolledCourses.get(i).getCourseId() == courseId) {
                grades.set(i, grade);
                System.out.println("✓ Grade assigned successfully!");
                return;
            }
        }
        throw new Exception("Course not found!");
    }

    public double getGrade(int courseId) throws Exception {
        for (int i = 0; i < enrolledCourses.size(); i++) {
            if (enrolledCourses.get(i).getCourseId() == courseId) {
                return grades.get(i);
            }
        }
        throw new Exception("Course not found!");
    }

    public double calculateGPA() {
        if (enrolledCourses.isEmpty()) {
            return 0.0;
        }

        double totalGrades = 0;
        int courseCount = 0;
        for (double grade : grades) {
            if (grade > 0) {
                totalGrades += grade;
                courseCount++;
            }
        }
        return courseCount > 0 ? totalGrades / courseCount : 0.0;
    }

    public String getLetterGrade(double percentage) {
        if (percentage >= 90) {
            return "A";
        }
        if (percentage >= 80) {
            return "B";
        }
        if (percentage >= 70) {
            return "C";
        }
        if (percentage >= 60) {
            return "D";
        }
        return "F";
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public void displayProfile() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("STUDENT PROFILE");
        System.out.println("=".repeat(80));
        System.out.println(toString());
        System.out.println("Student ID: " + studentId);
        System.out.println("Department: " + department);
        System.out.println("Semester: " + semester);
        System.out.println("Current GPA: " + String.format("%.2f", calculateGPA()));
        System.out.println("Enrolled Courses: " + enrolledCourses.size() + "/" + MAX_COURSES);
        System.out.println("=".repeat(80));
    }

    public void displayEnrolledCourses() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("ENROLLED COURSES - " + name);
        System.out.println("=".repeat(80));

        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled!");
        } else {
            for (int i = 0; i < enrolledCourses.size(); i++) {
                Course course = enrolledCourses.get(i);
                double grade = grades.get(i);
                System.out.println((i + 1) + ". " + course.getCourseName()
                        + " (ID: " + course.getCourseId()
                        + ") | Credits: " + course.getCredits()
                        + " | Grade: " + (grade > 0 ? String.format("%.1f", grade) + " (" + getLetterGrade(grade) + ")" : "Not Graded"));
            }
        }
        System.out.println("=".repeat(80));
    }
}
