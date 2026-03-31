package week02.scenario.studentcourseregistration;

import java.util.*;

public class StudentRegistrationServiceImpl implements RegistrationService {

    private Map<Integer, Student> students;
    private Map<Integer, Course> courses;

    public StudentRegistrationServiceImpl() {
        this.students = new HashMap<>();
        this.courses = new HashMap<>();
        initializeCourses();
    }

    private void initializeCourses() {
        courses.put(101, new Course(101, "Data Structures", "CS101", 4, "Dr. Sharma", 30));
        courses.put(102, new Course(102, "Web Development", "CS102", 3, "Prof. Singh", 25));
        courses.put(103, new Course(103, "Database Management", "CS103", 4, "Dr. Patel", 28));
        courses.put(104, new Course(104, "Object-Oriented Programming", "CS104", 4, "Prof. Kumar", 32));
        courses.put(105, new Course(105, "Web Design", "CS105", 3, "Dr. Verma", 20));
        courses.put(106, new Course(106, "Advanced Java", "CS106", 4, "Prof. Gupta", 25));
        courses.put(107, new Course(107, "Database Design", "CS107", 3, "Dr. Nair", 30));
        courses.put(108, new Course(108, "Software Engineering", "CS108", 4, "Prof. Desai", 25));
    }

    @Override
    public void registerStudent(Student student) {
        students.put(student.getPersonId(), student);
        System.out.println("✓ Student registered successfully!");
    }

    @Override
    public void removeStudent(int studentId) {
        if (students.containsKey(studentId)) {
            Student student = students.get(studentId);
            // Unenroll from all courses
            for (Course course : student.getEnrolledCourses()) {
                course.removeStudent(student);
            }
            students.remove(studentId);
            System.out.println("✓ Student removed successfully!");
        } else {
            System.out.println("✗ Student not found!");
        }
    }

    @Override
    public void enrollStudentInCourse(int studentId, int courseId) throws Exception {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);

        if (student == null) {
            throw new Exception("Student not found!");
        }
        if (course == null) {
            throw new Exception("Course not found!");
        }
        if (!course.isAvailable()) {
            throw new Exception("Course is full! No seats available.");
        }

        student.enrollCourse(course);
    }

    @Override
    public void dropCourseForStudent(int studentId, int courseId) throws Exception {
        Student student = students.get(studentId);
        if (student == null) {
            throw new Exception("Student not found!");
        }
        student.dropCourse(courseId);
    }

    @Override
    public void assignGradeToStudent(int studentId, int courseId, double grade) throws Exception {
        Student student = students.get(studentId);
        if (student == null) {
            throw new Exception("Student not found!");
        }
        student.assignGrade(courseId, grade);
    }

    @Override
    public Student getStudent(int studentId) {
        return students.get(studentId);
    }

    @Override
    public Course getCourse(int courseId) {
        return courses.get(courseId);
    }

    @Override
    public void displayAllStudents() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("ALL REGISTERED STUDENTS");
        System.out.println("=".repeat(80));
        if (students.isEmpty()) {
            System.out.println("No students registered!");
        } else {
            int count = 1;
            for (Student student : students.values()) {
                System.out.println(count + ". " + student);
                count++;
            }
        }
        System.out.println("=".repeat(80));
    }

    @Override
    public void displayAllCourses() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("AVAILABLE COURSES");
        System.out.println("=".repeat(80));
        if (courses.isEmpty()) {
            System.out.println("No courses available!");
        } else {
            for (Course course : courses.values()) {
                System.out.println(course);
            }
        }
        System.out.println("=".repeat(80));
    }

    public Map<Integer, Student> getAllStudents() {
        return students;
    }

    public Map<Integer, Course> getAllCourses() {
        return courses;
    }
}
