package study;

public class Baseball {

    public static void main(String[] args) {


        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Ball answers = new Ball();
        ValidationBall validationBall = new ValidationBall();
        boolean isRunGame = true;
        boolean isReset = true;
        boolean isReGame = true;

        while (isRunGame){

            if (isReset) {
                boolean isValidAnswers = false;
                while (!isValidAnswers){
                    answers.clear();
                    answers.createAnswer();
                    isValidAnswers = validationBall.validNumbers(answers.getNumbers());
                }
                inputView.showAnswer(answers.getNumbers());
                isReset = false;
            }

            boolean isAnswer;
            String reGameResult;
            boolean isValidInputNumbers = false;
            String inputNumber = inputView.inputMessage();
            Ball userBall = new Ball(inputNumber);
            isValidInputNumbers = validationBall.validNumbers(inputNumber);

            if (!isValidInputNumbers) {
                inputView.notValidInputNumbersMessage();
                continue;
            }

            PlayResult predictionResult = validationBall.validAnswer(answers, userBall);
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
