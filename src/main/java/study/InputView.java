package study;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

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

}
