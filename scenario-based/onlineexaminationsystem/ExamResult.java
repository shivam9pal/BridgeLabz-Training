package week02.scenario.onlineexaminationsystem;

public class ExamResult {

    private int resultId;
    private int studentId;
    private int examId;
    private double marksObtained;
    private double totalMarks;
    private double percentage;
    private String grade;
    private String status;
    private String submissionTime;

    public ExamResult(int resultId, int studentId, int examId, double marksObtained, double totalMarks) {
        this.resultId = resultId;
        this.studentId = studentId;
        this.examId = examId;
        this.marksObtained = marksObtained;
        this.totalMarks = totalMarks;
        this.percentage = (marksObtained / totalMarks) * 100;
        this.grade = calculateGrade(percentage);
        this.status = marksObtained >= (totalMarks * 0.4) ? "PASS" : "FAIL";
        this.submissionTime = new java.time.LocalDateTime.now().toString();
    }

    private String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        }
        if (percentage >= 80) {
            return "A";
        }
        if (percentage >= 70) {
            return "B";
        }
        if (percentage >= 60) {
            return "C";
        }
        if (percentage >= 50) {
            return "D";
        }
        return "F";
    }

    public int getResultId() {
        return resultId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getExamId() {
        return examId;
    }

    public double getMarksObtained() {
        return marksObtained;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getGrade() {
        return grade;
    }

    public String getStatus() {
        return status;
    }

    public String getSubmissionTime() {
        return submissionTime;
    }

    @Override
    public String toString() {
        return "Result ID: " + resultId
                + " | Student ID: " + studentId
                + " | Exam ID: " + examId
                + " | Marks: " + String.format("%.2f", marksObtained) + "/" + (int) totalMarks
                + " | Percentage: " + String.format("%.2f", percentage) + "%"
                + " | Grade: " + grade
                + " | Status: " + status;
    }
}
