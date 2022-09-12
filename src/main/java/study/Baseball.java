package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Baseball {

    public static void main(String[] args) {

        Baseball baseball = new Baseball();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        String[] answers = null;
        boolean isReset = true;
        boolean isRunGame = true;
        boolean isReGame = true;
        while (isRunGame){

            if (isReset) {
                boolean isValidAnswers = false;
                while (!isValidAnswers){
                    answers = baseball.createAnswer();
                    isValidAnswers = baseball.validNumbers(answers);
                }
                String answersToString = Arrays.toString(answers);
                System.out.println("정답 : " + answersToString);
                isReset = false;
            }

            boolean isAnswer;
            String reGameResult;
            boolean isValidInputNumbers = false;
            String inputNumber = inputView.inputMessage();
            isValidInputNumbers = baseball.validInputNumbers(inputNumber);

            if (!isValidInputNumbers) {
                inputView.notValidInputNumbersMessage();
                continue;
            }

            Integer[] predictionResult = baseball.validAnswer(answers, inputNumber);
            isAnswer = resultView.predictionResultMessage(predictionResult);

            if (isAnswer) {
                isReset = true;
                reGameResult = inputView.reGameMessage();
                isReGame = resultView.reGameResultMessage(reGameResult);
            }
            if (!isReGame) {
                isRunGame = false;
            }
            
        }

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
