package week02.scenario.onlineexaminationsystem;

import java.util.*;

public class Student {

    private int studentId;
    private String studentName;
    private String email;
    private String rollNumber;
    private Map<Integer, String> submittedAnswers; // examId -> answers

    public Student(int studentId, String studentName, String email, String rollNumber) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.rollNumber = rollNumber;
        this.submittedAnswers = new HashMap<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getEmail() {
        return email;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void submitAnswer(int examId, int questionId, String answer) {
        String key = examId + "_" + questionId;
        submittedAnswers.put(Integer.parseInt(key.replace("_", "")), answer);
    }

    public String getAnswer(int examId, int questionId) {
        String key = examId + "_" + questionId;
        return submittedAnswers.getOrDefault(Integer.parseInt(key.replace("_", "")), "");
    }

    public boolean hasSubmittedAnswer(int examId, int questionId) {
        String key = examId + "_" + questionId;
        return submittedAnswers.containsKey(Integer.parseInt(key.replace("_", "")));
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId
                + " | Name: " + studentName
                + " | Roll No: " + rollNumber
                + " | Email: " + email;
    }
}
