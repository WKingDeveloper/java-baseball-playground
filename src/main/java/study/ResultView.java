package study;

public class ResultView {

    boolean predictionResultMessage(PlayResult playResult) {
        if (playResult.isThreeStrike()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if (playResult.isFourBall()) {
            System.out.println("포볼입니다.");
            return false;
        }
        System.out.println(playResult.getResult()[0]+"볼 "+playResult.getResult()[1]+" 스트라이크 입니다.");
        return false;
    }

    boolean reGameResultMessage(String reGameResult) {
        if (reGameResult.equals("1")) {
            System.out.println("게임을 다시 시작합니다.");
            return true;
        }
        System.out.println("게임을 종료합니다.");
        return false;

    }

}
