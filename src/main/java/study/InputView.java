package study;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    void showAnswer(String answer) {
        System.out.println("정답 : " + answer);
    }

    String inputMessage() {
        System.out.println("숫자를 입력해 주세요.");
        String value = scanner.nextLine();
        return value;
    }

    String reGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String value = scanner.nextLine();
        return value;
    }

    void notValidInputNumbersMessage() {
        System.out.println("잘못된 숫자를 입력하셨습니다. 다시 입력해주세요.");
    }

}
