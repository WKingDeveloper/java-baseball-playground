package study;

import java.util.Arrays;

public class Baseball {

    public static void main(String[] args) {

        Ball ball = new Ball();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String[] answers = null;
        boolean isRunGame = true;
        boolean isReset = true;
        boolean isReGame = true;

        while (isRunGame){

            if (isReset) {
                boolean isValidAnswers = false;
                while (!isValidAnswers){
                    answers = ball.createAnswer();
                    isValidAnswers = ball.validNumbers(answers);
                }
                String answersToString = Arrays.toString(answers);
                System.out.println("정답 : " + answersToString);
                isReset = false;
            }

            boolean isAnswer;
            String reGameResult;
            boolean isValidInputNumbers = false;
            String inputNumber = inputView.inputMessage();
            isValidInputNumbers = ball.validInputNumbers(inputNumber);

            if (!isValidInputNumbers) {
                inputView.notValidInputNumbersMessage();
                continue;
            }

            Integer[] predictionResult = ball.validAnswer(answers, inputNumber);
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




}
