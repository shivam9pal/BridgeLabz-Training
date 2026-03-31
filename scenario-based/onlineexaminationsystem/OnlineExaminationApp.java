package week02.scenario.onlineexaminationsystem;

import java.util.*;

public class OnlineExaminationApp {

    private OnlineExaminationService service;
    private Scanner scanner;
    private int currentStudentId = -1;
    private boolean isAdmin = false;

    public OnlineExaminationApp() {
        this.service = new OnlineExaminationService();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        OnlineExaminationApp app = new OnlineExaminationApp();
        app.run();
    }

    public void run() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                      ONLINE EXAMINATION SYSTEM                                 ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");

        boolean running = true;
        while (running) {
            if (isAdmin) {
                running = handleAdminMenu();
            } else if (currentStudentId == -1) {
                running = handleLoginMenu();
            } else {
                running = handleStudentMenu();
            }
        }

        System.out.println("\n╔════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    Thank you for using the system! Goodbye!                     ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
        scanner.close();
    }

    // ====== LOGIN MENU ======
    private boolean handleLoginMenu() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("LOGIN");
        System.out.println("=".repeat(80));
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Register New Student");
        System.out.println("4. Exit");
        System.out.println("=".repeat(80));
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                loginStudent();
                break;
            case 2:
                loginAdmin();
                break;
            case 3:
                registerStudent();
                break;
            case 4:
                return false;
            default:
                System.out.println("✗ Invalid choice! Please try again.");
        }
        return true;
    }

    private void loginStudent() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("STUDENT LOGIN");
        System.out.println("-".repeat(80));

        System.out.print("Enter Student ID: ");
        int studentId = getIntInput();

        Student student = service.getStudent(studentId);
        if (student != null) {
            currentStudentId = studentId;
            System.out.println("✓ Welcome, " + student.getStudentName() + "!");
        } else {
            System.out.println("✗ Student not found!");
        }
    }

    private void loginAdmin() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("ADMIN LOGIN");
        System.out.println("-".repeat(80));

        System.out.print("Enter Admin Password (demo: admin123): ");
        String password = scanner.nextLine().trim();

        if (password.equals("admin123")) {
            isAdmin = true;
            System.out.println("✓ Admin login successful!");
        } else {
            System.out.println("✗ Invalid password!");
        }
    }

    private void registerStudent() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("STUDENT REGISTRATION");
        System.out.println("-".repeat(80));

        System.out.print("Enter Student ID: ");
        int studentId = getIntInput();

        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter Roll Number: ");
        String rollNumber = scanner.nextLine().trim();

        service.registerStudent(studentId, name, email, rollNumber);
        currentStudentId = studentId;
        System.out.println("✓ Welcome, " + name + "!");
    }

    // ====== ADMIN MENU ======
    private boolean handleAdminMenu() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("ADMIN MENU");
        System.out.println("=".repeat(80));
        System.out.println("1. Create Exam");
        System.out.println("2. Add Questions to Exam");
        System.out.println("3. View All Exams");
        System.out.println("4. View Exam Details");
        System.out.println("5. Activate/Deactivate Exam");
        System.out.println("6. View All Students");
        System.out.println("7. Enroll Student in Exam");
        System.out.println("8. Unenroll Student from Exam");
        System.out.println("9. Evaluate Exam");
        System.out.println("10. View All Results");
        System.out.println("11. Logout");
        System.out.println("12. Exit");
        System.out.println("=".repeat(80));
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                createExam();
                break;
            case 2:
                addQuestionsToExam();
                break;
            case 3:
                service.displayAllExams();
                break;
            case 4:
                viewExamDetails();
                break;
            case 5:
                toggleExamActivation();
                break;
            case 6:
                service.displayAllStudents();
                break;
            case 7:
                enrollStudentInExam();
                break;
            case 8:
                unenrollStudentFromExam();
                break;
            case 9:
                evaluateExam();
                break;
            case 10:
                service.displayAllResults();
                break;
            case 11:
                isAdmin = false;
                System.out.println("✓ Logged out successfully!");
                break;
            case 12:
                return false;
            default:
                System.out.println("✗ Invalid choice!");
        }
        return true;
    }

    private void createExam() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("CREATE NEW EXAM");
        System.out.println("-".repeat(80));

        System.out.print("Enter Exam ID: ");
        int examId = getIntInput();

        System.out.print("Enter Exam Name: ");
        String examName = scanner.nextLine().trim();

        System.out.print("Enter Subject: ");
        String subject = scanner.nextLine().trim();

        System.out.print("Enter Duration (minutes): ");
        int duration = getIntInput();

        System.out.print("Enter Exam Date (YYYY-MM-DD): ");
        String date = scanner.nextLine().trim();

        System.out.print("Enter Exam Time (HH:MM AM/PM): ");
        String time = scanner.nextLine().trim();

        service.createExam(examId, examName, subject, duration, date, time);
    }

    private void addQuestionsToExam() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("ADD QUESTIONS TO EXAM");
        System.out.println("-".repeat(80));

        System.out.print("Enter Exam ID: ");
        int examId = getIntInput();

        Exam exam = service.getExam(examId);
        if (exam == null) {
            System.out.println("✗ Exam not found!");
            return;
        }

        boolean addingQuestions = true;
        while (addingQuestions) {
            System.out.println("\n1. Add Objective Question");
            System.out.println("2. Add Descriptive Question");
            System.out.println("3. Done");
            System.out.print("Choose: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    addObjectiveQuestion(examId);
                    break;
                case 2:
                    addDescriptiveQuestion(examId);
                    break;
                case 3:
                    addingQuestions = false;
                    break;
                default:
                    System.out.println("✗ Invalid choice!");
            }
        }
    }

    private void addObjectiveQuestion(int examId) {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("ADD OBJECTIVE QUESTION");
        System.out.println("-".repeat(80));

        System.out.print("Enter Question ID: ");
        int qId = getIntInput();

        System.out.print("Enter Question Text: ");
        String qText = scanner.nextLine().trim();

        System.out.print("Enter Marks: ");
        int marks = getIntInput();

        System.out.print("Enter Option A: ");
        String optA = scanner.nextLine().trim();

        System.out.print("Enter Option B: ");
        String optB = scanner.nextLine().trim();

        System.out.print("Enter Option C: ");
        String optC = scanner.nextLine().trim();

        System.out.print("Enter Option D: ");
        String optD = scanner.nextLine().trim();

        System.out.print("Enter Correct Answer (A/B/C/D): ");
        String correct = scanner.nextLine().trim();

        try {
            ObjectiveQuestion question = new ObjectiveQuestion(qId, qText, marks, optA, optB, optC, optD, correct);
            service.addQuestionToExam(examId, question);
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void addDescriptiveQuestion(int examId) {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("ADD DESCRIPTIVE QUESTION");
        System.out.println("-".repeat(80));

        System.out.print("Enter Question ID: ");
        int qId = getIntInput();

        System.out.print("Enter Question Text: ");
        String qText = scanner.nextLine().trim();

        System.out.print("Enter Marks: ");
        int marks = getIntInput();

        System.out.print("Enter Sample Answer: ");
        String sampleAns = scanner.nextLine().trim();

        System.out.print("Enter Minimum Word Limit: ");
        int minWords = getIntInput();

        System.out.print("Enter Maximum Word Limit: ");
        int maxWords = getIntInput();

        try {
            DescriptiveQuestion question = new DescriptiveQuestion(qId, qText, marks, sampleAns, minWords, maxWords);
            service.addQuestionToExam(examId, question);
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void viewExamDetails() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("VIEW EXAM DETAILS");
        System.out.println("-".repeat(80));

        System.out.print("Enter Exam ID: ");
        int examId = getIntInput();

        service.displayExamDetails(examId);
    }

    private void toggleExamActivation() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("ACTIVATE/DEACTIVATE EXAM");
        System.out.println("-".repeat(80));

        System.out.print("Enter Exam ID: ");
        int examId = getIntInput();

        Exam exam = service.getExam(examId);
        if (exam == null) {
            System.out.println("✗ Exam not found!");
            return;
        }

        try {
            if (exam.isActive()) {
                service.deactivateExam(examId);
            } else {
                service.activateExam(examId);
            }
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void enrollStudentInExam() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("ENROLL STUDENT IN EXAM");
        System.out.println("-".repeat(80));

        System.out.print("Enter Student ID: ");
        int studentId = getIntInput();

        System.out.print("Enter Exam ID: ");
        int examId = getIntInput();

        try {
            service.enrollStudentInExam(studentId, examId);
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void unenrollStudentFromExam() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("UNENROLL STUDENT FROM EXAM");
        System.out.println("-".repeat(80));

        System.out.print("Enter Student ID: ");
        int studentId = getIntInput();

        System.out.print("Enter Exam ID: ");
        int examId = getIntInput();

        try {
            service.unenrollStudentFromExam(studentId, examId);
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    private void evaluateExam() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("EVALUATE EXAM");
        System.out.println("-".repeat(80));

        System.out.print("Enter Student ID: ");
        int studentId = getIntInput();

        System.out.print("Enter Exam ID: ");
        int examId = getIntInput();

        try {
            service.evaluateExam(studentId, examId);
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    // ====== STUDENT MENU ======
    private boolean handleStudentMenu() {
        Student student = service.getStudent(currentStudentId);
        if (student == null) {
            currentStudentId = -1;
            return true;
        }

        System.out.println("\n" + "=".repeat(80));
        System.out.println("STUDENT MENU - " + student.getStudentName());
        System.out.println("=".repeat(80));
        System.out.println("1. View My Profile");
        System.out.println("2. View Available Exams");
        System.out.println("3. View My Enrolled Exams");
        System.out.println("4. Take Exam");
        System.out.println("5. View My Results");
        System.out.println("6. Logout");
        System.out.println("7. Exit");
        System.out.println("=".repeat(80));
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                displayStudentProfile();
                break;
            case 2:
                displayAvailableExams();
                break;
            case 3:
                displayEnrolledExams();
                break;
            case 4:
                takeExam();
                break;
            case 5:
                viewMyResults();
                break;
            case 6:
                currentStudentId = -1;
                System.out.println("✓ Logged out successfully!");
                break;
            case 7:
                return false;
            default:
                System.out.println("✗ Invalid choice!");
        }
        return true;
    }

    private void displayStudentProfile() {
        Student student = service.getStudent(currentStudentId);
        System.out.println("\n" + "=".repeat(80));
        System.out.println("MY PROFILE");
        System.out.println("=".repeat(80));
        System.out.println(student);
        System.out.println("=".repeat(80));
    }

    private void displayAvailableExams() {
        service.displayAllExams();
    }

    private void displayEnrolledExams() {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("MY ENROLLED EXAMS");
        System.out.println("=".repeat(100));

        Map<Integer, Exam> allExams = service.getAllExams();
        boolean found = false;
        for (Exam exam : allExams.values()) {
            if (exam.isStudentEnrolled(currentStudentId)) {
                System.out.println(exam);
                found = true;
            }
        }

        if (!found) {
            System.out.println("You are not enrolled in any exam!");
        }
        System.out.println("=".repeat(100));
    }

    private void takeExam() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("TAKE EXAM");
        System.out.println("-".repeat(80));

        displayEnrolledExams();

        System.out.print("Enter Exam ID: ");
        int examId = getIntInput();

        Exam exam = service.getExam(examId);
        if (exam == null) {
            System.out.println("✗ Exam not found!");
            return;
        }

        if (!exam.isActive()) {
            System.out.println("✗ This exam is not currently active!");
            return;
        }

        if (!exam.isStudentEnrolled(currentStudentId)) {
            System.out.println("✗ You are not enrolled in this exam!");
            return;
        }

        Student student = service.getStudent(currentStudentId);
        System.out.println("\n" + "=".repeat(100));
        System.out.println("EXAM: " + exam.getExamName() + " | Duration: " + exam.getDuration() + " minutes");
        System.out.println("Total Questions: " + exam.getQuestions().size() + " | Total Marks: " + exam.getTotalMarks());
        System.out.println("=".repeat(100));

        for (Question question : exam.getQuestions()) {
            question.displayQuestion();

            System.out.print("\nYour Answer: ");
            String answer = scanner.nextLine().trim();

            try {
                service.submitAnswer(currentStudentId, examId, question.getQuestionId(), answer);
            } catch (ExamTimeExpiredException e) {
                System.out.println("✗ " + e.getMessage());
                return;
            } catch (Exception e) {
                System.out.println("✗ Error: " + e.getMessage());
            }
        }

        System.out.println("\n" + "=".repeat(100));
        System.out.println("✓ Exam submitted successfully!");
        System.out.println("=".repeat(100));
    }

    private void viewMyResults() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("VIEW MY RESULTS");
        System.out.println("-".repeat(80));

        System.out.print("Enter Exam ID: ");
        int examId = getIntInput();

        service.displayStudentResult(currentStudentId, examId);
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
}
