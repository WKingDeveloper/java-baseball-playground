package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ball {

    String numbers = "";

    Ball() {

    }

    Ball(String number) {
        this.numbers = number;
    }

    public String getNumbers() {
        return numbers;
    }

    public void createAnswer() {
        List<String> candidateAnswers = createCandidateAnswers();
        this.numbers = selectAnswers(numbers, candidateAnswers);
    }

    private List<String> createCandidateAnswers() {
        List<String> candidateAnswers = new ArrayList();

        for (int i = 1; i < 10; i++) {
            candidateAnswers.add(String.valueOf(i));
        }
        return candidateAnswers;
    }

    private String selectAnswers(String answers, List<String> candidateAnswers) {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int num = random.nextInt(9-i);
            answers += candidateAnswers.get(num);
            candidateAnswers.remove(num);
        }
        return answers;
    }



}
