package week02.scenario.studentcourseregistration;

import java.util.*;

public class StudentCourseRegistrationApp {

    private RegistrationService registrationService;
    private Scanner scanner;
    private int currentStudentId = -1;

    public StudentCourseRegistrationApp() {
        this.registrationService = new StudentRegistrationServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        StudentCourseRegistrationApp app = new StudentCourseRegistrationApp();
        app.run();
    }

    public void run() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    STUDENT COURSE REGISTRATION SYSTEM                         ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");

        boolean running = true;
        while (running) {
            if (currentStudentId == -1) {
                running = handleAuthMenu();
            } else {
                running = handleMainMenu();
            }
        }

        System.out.println("\n╔════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                           Thank you! Goodbye!                                  ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
        scanner.close();
    }

    // ====== AUTHENTICATION MENU ======
    private boolean handleAuthMenu() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("AUTHENTICATION MENU");
        System.out.println("=".repeat(80));
        System.out.println("1. Register as New Student");
        System.out.println("2. Login (Use Student ID)");
        System.out.println("3. Admin Panel");
        System.out.println("4. Exit");
        System.out.println("=".repeat(80));
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                registerNewStudent();
                break;
            case 2:
                loginStudent();
                break;
            case 3:
                adminPanel();
                break;
            case 4:
                return false;
            default:
                System.out.println("✗ Invalid choice! Please try again.");
        }
        return true;
    }

    private void registerNewStudent() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("STUDENT REGISTRATION");
        System.out.println("-".repeat(80));

        System.out.print("Enter Person ID: ");
        int personId = getIntInput();

        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine().trim();

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine().trim();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine().trim();

        System.out.print("Enter Current Semester: ");
        int semester = getIntInput();

        Student student = new Student(personId, name, email, phone, studentId, department, semester);
        registrationService.registerStudent(student);
        currentStudentId = personId;
        System.out.println("✓ Welcome, " + name + "!");
    }

    private void loginStudent() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("STUDENT LOGIN");
        System.out.println("-".repeat(80));

        System.out.print("Enter Person ID: ");
        int personId = getIntInput();

        if (registrationService.getStudent(personId) != null) {
            currentStudentId = personId;
            System.out.println("✓ Login successful!");
        } else {
            System.out.println("✗ Student not found! Please register first.");
        }
    }

    private void adminPanel() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("ADMIN PANEL");
        System.out.println("=".repeat(80));
        System.out.println("1. View All Students");
        System.out.println("2. View All Courses");
        System.out.println("3. Assign Grade to Student");
        System.out.println("4. Back");
        System.out.println("=".repeat(80));
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                registrationService.displayAllStudents();
                break;
            case 2:
                registrationService.displayAllCourses();
                break;
            case 3:
                assignGradeAdmin();
                break;
            case 4:
                break;
            default:
                System.out.println("✗ Invalid choice!");
        }
    }

    private void assignGradeAdmin() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("ASSIGN GRADE TO STUDENT");
        System.out.println("-".repeat(80));

        registrationService.displayAllStudents();

        System.out.print("Enter Student Person ID: ");
        int studentId = getIntInput();

        Student student = registrationService.getStudent(studentId);
        if (student == null) {
            System.out.println("✗ Student not found!");
            return;
        }

        student.displayEnrolledCourses();

        System.out.print("Enter Course ID: ");
        int courseId = getIntInput();

        System.out.print("Enter Grade (0-100): ");
        double grade = getDoubleInput();

        try {
            registrationService.assignGradeToStudent(studentId, courseId, grade);
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    // ====== MAIN MENU ======
    private boolean handleMainMenu() {
        Student student = registrationService.getStudent(currentStudentId);
        if (student == null) {
            System.out.println("✗ Session expired!");
            currentStudentId = -1;
            return true;
        }

        System.out.println("\n" + "=".repeat(80));
        System.out.println("MAIN MENU - " + student.getName() + " (ID: " + student.getStudentId() + ")");
        System.out.println("=".repeat(80));
        System.out.println("1. View My Profile");
        System.out.println("2. View Enrolled Courses");
        System.out.println("3. View All Available Courses");
        System.out.println("4. Enroll in Course");
        System.out.println("5. Drop Course");
        System.out.println("6. View My Grades");
        System.out.println("7. View Course Details");
        System.out.println("8. Logout");
        System.out.println("9. Exit");
        System.out.println("=".repeat(80));
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                student.displayProfile();
                break;
            case 2:
                student.displayEnrolledCourses();
                break;
            case 3:
                registrationService.displayAllCourses();
                break;
            case 4:
                enrollInCourse();
                break;
            case 5:
                dropCourse();
                break;
            case 6:
                viewGrades();
                break;
            case 7:
                viewCourseDetails();
                break;
            case 8:
                currentStudentId = -1;
                System.out.println("✓ Logged out successfully!");
                break;
            case 9:
                return false;
            default:
                System.out.println("✗ Invalid choice! Please try again.");
        }
        return true;
    }

    // ====== COURSE ENROLLMENT ======
    private void enrollInCourse() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("ENROLL IN COURSE");
        System.out.println("-".repeat(80));

        registrationService.displayAllCourses();

        System.out.print("Enter Course ID to enroll: ");
        int courseId = getIntInput();

        try {
            registrationService.enrollStudentInCourse(currentStudentId, courseId);
        } catch (CourseLimitExceededException e) {
            System.out.println("✗ Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    // ====== COURSE DROP ======
    private void dropCourse() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("DROP COURSE");
        System.out.println("-".repeat(80));

        Student student = registrationService.getStudent(currentStudentId);
        student.displayEnrolledCourses();

        if (student.getEnrolledCourses().isEmpty()) {
            System.out.println("No courses to drop!");
            return;
        }

        System.out.print("Enter Course ID to drop: ");
        int courseId = getIntInput();

        try {
            registrationService.dropCourseForStudent(currentStudentId, courseId);
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    // ====== VIEW GRADES ======
    private void viewGrades() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("MY GRADES");
        System.out.println("=".repeat(80));

        Student student = registrationService.getStudent(currentStudentId);
        List<Course> courses = student.getEnrolledCourses();
        List<Double> grades = student.getGrades();

        if (courses.isEmpty()) {
            System.out.println("No enrolled courses!");
        } else {
            System.out.println("GPA: " + String.format("%.2f", student.calculateGPA()));
            System.out.println("-".repeat(80));
            for (int i = 0; i < courses.size(); i++) {
                Course course = courses.get(i);
                double grade = grades.get(i);
                String letterGrade = grade > 0 ? student.getLetterGrade(grade) : "N/A";
                String gradeDisplay = grade > 0 ? String.format("%.1f", grade) + " (" + letterGrade + ")" : "Not Graded";
                System.out.println(course.getCourseName() + " (" + course.getCourseCode() + "): " + gradeDisplay);
            }
        }
        System.out.println("=".repeat(80));
    }

    // ====== VIEW COURSE DETAILS ======
    private void viewCourseDetails() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("VIEW COURSE DETAILS");
        System.out.println("-".repeat(80));

        System.out.print("Enter Course ID: ");
        int courseId = getIntInput();

        Course course = registrationService.getCourse(courseId);
        if (course != null) {
            System.out.println("\n" + "=".repeat(80));
            System.out.println(course);
            System.out.println("-".repeat(80));
            System.out.println("Enrolled Students: " + course.getEnrolledStudents().size() + "/" + course.getCapacity());
            if (!course.getEnrolledStudents().isEmpty()) {
                System.out.println("Student List:");
                for (Student student : course.getEnrolledStudents()) {
                    System.out.println("  • " + student.getName() + " (" + student.getStudentId() + ")");
                }
            }
            System.out.println("=".repeat(80));
        } else {
            System.out.println("✗ Course not found!");
        }
    }

    // ====== UTILITY METHODS ======
    private int getIntInput() {
        try {
            int value = Integer.parseInt(scanner.nextLine().trim());
            return value;
        } catch (NumberFormatException e) {
            System.out.println("✗ Invalid input! Please enter a number.");
            return -1;
        }
    }

    private double getDoubleInput() {
        try {
            double value = Double.parseDouble(scanner.nextLine().trim());
            return value;
        } catch (NumberFormatException e) {
            System.out.println("✗ Invalid input! Please enter a valid number.");
            return 0.0;
        }
    }
}
