package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baseball {

    public static void main(String[] args) {

    }

    public Integer[] createAnswer() {
        Integer[] answers = new Integer[3];
        List<Integer> candidateAnswers = createCandidateAnswers();
        answers = selectAnswers(answers, candidateAnswers);
        return answers;
    }

    public boolean validNumbers(Integer[] result) {
        boolean isValid = true;
        if(result.length != 3){
            isValid = false;
        }
        if(result[0]==result[1] ||result[0]==result[2] || result[2]==result[1]){
            isValid = false;
        }
        return isValid;
    }

    private List<Integer> createCandidateAnswers() {
        List<Integer> candidateAnswers = new ArrayList();

        for (int i = 1; i < 10; i++) {
            candidateAnswers.add(i);
        }
        return candidateAnswers;
    }

    private Integer[] selectAnswers(Integer[] answers, List<Integer> candidateAnswers) {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int num = random.nextInt(9-i);
            answers[i] = candidateAnswers.get(num);
            candidateAnswers.remove(num);
        }
        return answers;
    }

}
