package week03.scenariobased.examproctor;
import java.util.*;

class ExamProctor {
    Stack<Integer> navigation = new Stack<>();
    HashMap<Integer, String> answers = new HashMap<>();
    HashMap<Integer, String> correct = new HashMap<>();

    ExamProctor() {
        // Correct answers
        correct.put(1, "A");
        correct.put(2, "B");
        correct.put(3, "C");
    }

    // Open a question
    void openQuestion(int qid) {
        navigation.push(qid);
        System.out.println("Opened Question: " + qid);
    }

    // Answer a question
    void answerQuestion(int qid, String ans) {
        answers.put(qid, ans);
        System.out.println("Answered Q" + qid + " with " + ans);
    }

    // Go back to last visited question
    void goBack() {
        if (navigation.isEmpty()) {
            System.out.println("No previous question.");
            return;
        }
        int last = navigation.pop();
        System.out.println("Back from Question: " + last);
    }

    // Submit exam and calculate score
    int submitExam() {
        int score = 0;

        for (int qid : correct.keySet()) {
            if (answers.containsKey(qid)) {
                if (answers.get(qid).equals(correct.get(qid))) {
                    score++;
                }
            }
        }

        return score;
    }
}

