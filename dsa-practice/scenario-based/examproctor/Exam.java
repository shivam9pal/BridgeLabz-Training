package week03.scenariobased.examproctor;

public class Exam {
    public static void main(String[] args) {

        ExamProctor exam = new ExamProctor();

        exam.openQuestion(1);
        exam.answerQuestion(1, "A");
        exam.openQuestion(2);
        exam.answerQuestion(2, "C");
        exam.openQuestion(3);
        exam.answerQuestion(3, "C");

        exam.goBack();

        int result = exam.submitExam();
        System.out.println("Final Score: " + result);
    }
}

