package week02.scenario.onlineexaminationsystem;

import java.util.*;

public class Exam {

    private int examId;
    private String examName;
    private String subject;
    private int duration; // in minutes
    private int totalMarks;
    private List<Question> questions;
    private Set<Integer> enrolledStudents;
    private String examDate;
    private String examTime;
    private boolean isActive;

    public Exam(int examId, String examName, String subject, int duration, String examDate, String examTime) {
        this.examId = examId;
        this.examName = examName;
        this.subject = subject;
        this.duration = duration;
        this.examDate = examDate;
        this.examTime = examTime;
        this.questions = new ArrayList<>();
        this.enrolledStudents = new HashSet<>();
        this.totalMarks = 0;
        this.isActive = false;
    }

    public int getExamId() {
        return examId;
    }

    public String getExamName() {
        return examName;
    }

    public String getSubject() {
        return subject;
    }

    public int getDuration() {
        return duration;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public String getExamDate() {
        return examDate;
    }

    public String getExamTime() {
        return examTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public Set<Integer> getEnrolledStudents() {
        return enrolledStudents;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public void addQuestion(Question question) {
        questions.add(question);
        totalMarks += question.getMarks();
        System.out.println("✓ Question added successfully!");
    }

    public void removeQuestion(int questionId) throws Exception {
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getQuestionId() == questionId) {
                Question q = questions.remove(i);
                totalMarks -= q.getMarks();
                System.out.println("✓ Question removed successfully!");
                return;
            }
        }
        throw new Exception("Question not found!");
    }

    public void enrollStudent(int studentId) {
        enrolledStudents.add(studentId);
    }

    public void removeStudent(int studentId) {
        enrolledStudents.remove(studentId);
    }

    public boolean isStudentEnrolled(int studentId) {
        return enrolledStudents.contains(studentId);
    }

    @Override
    public String toString() {
        return "Exam ID: " + examId
                + " | Name: " + examName
                + " | Subject: " + subject
                + " | Duration: " + duration + " min"
                + " | Total Marks: " + totalMarks
                + " | Date: " + examDate
                + " | Time: " + examTime
                + " | Status: " + (isActive ? "Active" : "Inactive")
                + " | Enrolled: " + enrolledStudents.size();
    }
}
