package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baseball {

    public static void main(String[] args) {

    }

    public String[] createAnswer() {
        String[] answers = new String[3];
        List<String> candidateAnswers = createCandidateAnswers();
        answers = selectAnswers(answers, candidateAnswers);
        return answers;
    }

    public boolean validNumbers(String[] result) {
        boolean isValid = true;
        if(result.length != 3){
            isValid = false;
        }
        if(result[0]==result[1] ||result[0]==result[2] || result[2]==result[1]){
            isValid = false;
        }
        return isValid;
    }

    private List<String> createCandidateAnswers() {
        List<String> candidateAnswers = new ArrayList();

        for (int i = 1; i < 10; i++) {
            candidateAnswers.add(String.valueOf(i));
        }
        return candidateAnswers;
    }

    private String[] selectAnswers(String[] answers, List<String> candidateAnswers) {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int num = random.nextInt(9-i);
            answers[i] = candidateAnswers.get(num);
            candidateAnswers.remove(num);
        }
        return answers;
    }

    public Integer[] validAnswer(String[] answers, String question) {
        String answer = answers[0] + answers[1] + answers[2];
        Integer[] result = {0,0};
        for (int i = 0; i < 3; i++) {
            String q = String.valueOf(question.charAt(i));
            if (answers[i].equals(q)) {
                result[1] += 1;
                continue;
            }
            if (answer.contains(q)) {
                result[0] += 1;
            }
        }
        return result;
    }

}
