package week02.scenario.onlineexaminationsystem;

import java.util.*;

public class OnlineExaminationService {

    private Map<Integer, Exam> exams;
    private Map<Integer, Student> students;
    private Map<Integer, ExamResult> results;
    private int resultIdCounter = 1001;

    public OnlineExaminationService() {
        this.exams = new HashMap<>();
        this.students = new HashMap<>();
        this.results = new HashMap<>();
        initializeData();
    }

    private void initializeData() {
        // Initialize sample exams
        createExam(501, "Java Fundamentals", "OOP Concepts", 60, "2026-01-20", "10:00 AM");
        createExam(502, "Database Management", "SQL & RDBMS", 90, "2026-01-22", "02:00 PM");
        createExam(503, "Web Development", "HTML, CSS, JavaScript", 120, "2026-01-25", "10:00 AM");

        // Initialize sample students
        registerStudent(2001, "Amit Kumar", "amit@example.com", "CS001");
        registerStudent(2002, "Priya Singh", "priya@example.com", "CS002");
        registerStudent(2003, "Rahul Patel", "rahul@example.com", "CS003");
        registerStudent(2004, "Sneha Sharma", "sneha@example.com", "CS004");
    }

    // ====== EXAM MANAGEMENT ======
    public void createExam(int examId, String examName, String subject, int duration, String date, String time) {
        Exam exam = new Exam(examId, examName, subject, duration, date, time);
        exams.put(examId, exam);
        System.out.println("✓ Exam created successfully!");
    }

    public Exam getExam(int examId) {
        return exams.get(examId);
    }

    public void addQuestionToExam(int examId, Question question) throws Exception {
        Exam exam = exams.get(examId);
        if (exam == null) {
            throw new Exception("Exam not found!");
        }
        exam.addQuestion(question);
    }

    public void removeQuestionFromExam(int examId, int questionId) throws Exception {
        Exam exam = exams.get(examId);
        if (exam == null) {
            throw new Exception("Exam not found!");
        }
        exam.removeQuestion(questionId);
    }

    public void activateExam(int examId) throws Exception {
        Exam exam = exams.get(examId);
        if (exam == null) {
            throw new Exception("Exam not found!");
        }
        if (exam.getQuestions().isEmpty()) {
            throw new Exception("Cannot activate exam without questions!");
        }
        exam.setActive(true);
        System.out.println("✓ Exam activated successfully!");
    }

    public void deactivateExam(int examId) throws Exception {
        Exam exam = exams.get(examId);
        if (exam == null) {
            throw new Exception("Exam not found!");
        }
        exam.setActive(false);
        System.out.println("✓ Exam deactivated successfully!");
    }

    public void displayAllExams() {
        System.out.println("\n" + "=".repeat(120));
        System.out.println("ALL EXAMS");
        System.out.println("=".repeat(120));
        if (exams.isEmpty()) {
            System.out.println("No exams available!");
        } else {
            for (Exam exam : exams.values()) {
                System.out.println(exam);
            }
        }
        System.out.println("=".repeat(120));
    }

    public void displayExamDetails(int examId) {
        Exam exam = exams.get(examId);
        if (exam != null) {
            System.out.println("\n" + "=".repeat(100));
            System.out.println("EXAM DETAILS");
            System.out.println("=".repeat(100));
            System.out.println(exam);
            System.out.println("-".repeat(100));
            System.out.println("Questions (" + exam.getQuestions().size() + "):");
            for (Question q : exam.getQuestions()) {
                System.out.println("  • Q" + q.getQuestionId() + " [" + q.getQuestionType() + "] - "
                        + q.getMarks() + " marks");
            }
            System.out.println("=".repeat(100));
        } else {
            System.out.println("✗ Exam not found!");
        }
    }

    // ====== STUDENT MANAGEMENT ======
    public void registerStudent(int studentId, String name, String email, String rollNumber) {
        Student student = new Student(studentId, name, email, rollNumber);
        students.put(studentId, student);
        System.out.println("✓ Student registered successfully!");
    }

    public Student getStudent(int studentId) {
        return students.get(studentId);
    }

    public void displayAllStudents() {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("ALL REGISTERED STUDENTS");
        System.out.println("=".repeat(100));
        if (students.isEmpty()) {
            System.out.println("No students registered!");
        } else {
            int count = 1;
            for (Student student : students.values()) {
                System.out.println(count + ". " + student);
                count++;
            }
        }
        System.out.println("=".repeat(100));
    }

    // ====== ENROLLMENT ======
    public void enrollStudentInExam(int studentId, int examId) throws Exception {
        Student student = students.get(studentId);
        Exam exam = exams.get(examId);

        if (student == null) {
            throw new Exception("Student not found!");
        }
        if (exam == null) {
            throw new Exception("Exam not found!");
        }

        exam.enrollStudent(studentId);
        System.out.println("✓ Student enrolled in exam successfully!");
    }

    public void unenrollStudentFromExam(int studentId, int examId) throws Exception {
        Student student = students.get(studentId);
        Exam exam = exams.get(examId);

        if (student == null) {
            throw new Exception("Student not found!");
        }
        if (exam == null) {
            throw new Exception("Exam not found!");
        }

        exam.removeStudent(studentId);
        System.out.println("✓ Student unenrolled from exam successfully!");
    }

    public void displayEnrolledStudents(int examId) {
        Exam exam = exams.get(examId);
        if (exam == null) {
            System.out.println("✗ Exam not found!");
            return;
        }

        System.out.println("\n" + "=".repeat(100));
        System.out.println("STUDENTS ENROLLED IN: " + exam.getExamName());
        System.out.println("=".repeat(100));

        if (exam.getEnrolledStudents().isEmpty()) {
            System.out.println("No students enrolled!");
        } else {
            int count = 1;
            for (Integer studentId : exam.getEnrolledStudents()) {
                Student student = students.get(studentId);
                if (student != null) {
                    System.out.println(count + ". " + student);
                    count++;
                }
            }
        }
        System.out.println("=".repeat(100));
    }

    // ====== ANSWER SUBMISSION & EVALUATION ======
    public void submitAnswer(int studentId, int examId, int questionId, String answer) throws ExamTimeExpiredException, Exception {
        Student student = students.get(studentId);
        Exam exam = exams.get(examId);

        if (student == null) {
            throw new Exception("Student not found!");
        }
        if (exam == null) {
            throw new Exception("Exam not found!");
        }
        if (!exam.isActive()) {
            throw new ExamTimeExpiredException("Exam is not active! Cannot submit answers.");
        }

        student.submitAnswer(examId, questionId, answer);
        System.out.println("✓ Answer submitted successfully!");
    }

    public void evaluateExam(int studentId, int examId) throws Exception {
        Student student = students.get(studentId);
        Exam exam = exams.get(examId);

        if (student == null) {
            throw new Exception("Student not found!");
        }
        if (exam == null) {
            throw new Exception("Exam not found!");
        }

        double totalMarks = 0;
        ObjectiveEvaluator objEvaluator = new ObjectiveEvaluator();
        DescriptiveEvaluator descEvaluator = new DescriptiveEvaluator();

        System.out.println("\n" + "-".repeat(100));
        System.out.println("EVALUATING ANSWERS FOR: " + student.getStudentName());
        System.out.println("-".repeat(100));

        for (Question question : exam.getQuestions()) {
            String answer = student.getAnswer(examId, question.getQuestionId());
            double marksAwarded = 0;

            if (question instanceof ObjectiveQuestion) {
                marksAwarded = objEvaluator.evaluateAnswer(question, answer);
                System.out.println("Q" + question.getQuestionId() + " [Objective]: "
                        + (marksAwarded == question.getMarks() ? "✓ Correct" : "✗ Wrong"));
            } else if (question instanceof DescriptiveQuestion) {
                if (answer.isEmpty()) {
                    marksAwarded = 0;
                    System.out.println("Q" + question.getQuestionId() + " [Descriptive]: ✗ Not Attempted");
                } else {
                    marksAwarded = descEvaluator.evaluateAnswer(question, answer);
                    DescriptiveQuestion dq = (DescriptiveQuestion) question;
                    System.out.println("Q" + question.getQuestionId() + " [Descriptive]: "
                            + dq.countWords(answer) + " words");
                }
            }

            totalMarks += marksAwarded;
        }

        ExamResult result = new ExamResult(resultIdCounter++, studentId, examId, totalMarks, exam.getTotalMarks());
        results.put(result.getResultId(), result);
        System.out.println("-".repeat(100));
        System.out.println("✓ Exam evaluated successfully!");
    }

    public void displayStudentResult(int studentId, int examId) {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("EXAM RESULT");
        System.out.println("=".repeat(100));

        ExamResult result = null;
        for (ExamResult r : results.values()) {
            if (r.getStudentId() == studentId && r.getExamId() == examId) {
                result = r;
                break;
            }
        }

        if (result != null) {
            Student student = students.get(studentId);
            Exam exam = exams.get(examId);
            System.out.println("Student: " + student.getStudentName() + " (" + student.getRollNumber() + ")");
            System.out.println("Exam: " + exam.getExamName());
            System.out.println(result);
            System.out.println("-".repeat(100));
            System.out.println("Remark: " + (result.getStatus().equals("PASS")
                    ? "Congratulations! You passed the exam."
                    : "Please try again in the next exam."));
        } else {
            System.out.println("No result found for this student and exam!");
        }
        System.out.println("=".repeat(100));
    }

    public void displayAllResults() {
        System.out.println("\n" + "=".repeat(120));
        System.out.println("ALL EXAM RESULTS");
        System.out.println("=".repeat(120));
        if (results.isEmpty()) {
            System.out.println("No results available yet!");
        } else {
            for (ExamResult result : results.values()) {
                System.out.println(result);
            }
        }
        System.out.println("=".repeat(120));
    }

    public Map<Integer, Exam> getAllExams() {
        return exams;
    }

    public Map<Integer, Student> getAllStudents() {
        return students;
    }
}
