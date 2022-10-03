package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ball {

    String[] answers = new String[3];

    public String[] createAnswer() {
        List<String> candidateAnswers = createCandidateAnswers();
        answers = selectAnswers(answers, candidateAnswers);
        return answers;
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

    public boolean validNumbers(String[] result) {
        boolean isValid = true;
        if(result.length != 3){
            isValid = false;
            return isValid;
        }
        if(result[0]==result[1] ||result[0]==result[2] || result[2]==result[1]){
            isValid = false;
        }
        return isValid;
    }

    public boolean validInputNumbers(String result) {
        boolean isValid = true;
        if(result.length() != 3){
            isValid = false;
            return isValid;
        }
        if(result.charAt(0) == result.charAt(1) ||
                result.charAt(0) == result.charAt(2) ||
                result.charAt(1) == result.charAt(2)) {
            isValid = false;
        }
        return isValid;
    }

    public PlayResult validAnswer(String[] answers, String question) {
        PlayResult playResult = new PlayResult();
        String answer = answers[0] + answers[1] + answers[2];
        for (int i = 0; i < 3; i++) {
            String q = String.valueOf(question.charAt(i));
            if (answers[i].equals(q)) {
                playResult.addStrike();
                continue;
            }
            if (answer.contains(q)) {
                playResult.addBall();
            }
        }
        return playResult;
    }
}
