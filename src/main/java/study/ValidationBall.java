package study;

public class ValidationBall {
    public boolean validNumbers(String result) {
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


    public PlayResult validAnswer(Ball answers, Ball question) {
        PlayResult playResult = new PlayResult();
        for (int i = 0; i < 3; i++) {
            if (answers.getNumbers().substring(i, i + 1).equals(question.getNumbers().substring(i, i + 1))) {
                playResult.addStrike();
                continue;
            }
            if (answers.getNumbers().contains(question.getNumbers().substring(i, i + 1))) {
                playResult.addBall();
            }
        }
        return playResult;
    }
}
