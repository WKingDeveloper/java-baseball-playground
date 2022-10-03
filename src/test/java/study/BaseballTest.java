package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballTest {

    Ball ball = new Ball();

    @Test
    @DisplayName("각기 다른 3자리 숫자가 랜덤으로 나오게 하기")
    void createAnswerTest() {
        String[] result = ball.createAnswer();
        boolean isAnswerValid = ball.validNumbers(result);
        assertThat(result.length).isEqualTo(3);
        assertThat(isAnswerValid).isEqualTo(true);
    }

    @Test
    @DisplayName("3자리 숫자 valid 실패한 경우")
    void validNumberIsFalse() {
        String[] result1 = {"1", "2", "3", "4"};
        String[] result2 = {"2", "5", "5"};
        boolean isAnswerValid1 = ball.validNumbers(result1);
        boolean isAnswerValid2 = ball.validNumbers(result2);
        assertThat(isAnswerValid1).isEqualTo(false);
        assertThat(isAnswerValid2).isEqualTo(false);
    }

    @Test
    @DisplayName("3자리 숫자 입력 후 결과 확인")
    void validAnswerTest() {
        String[] answer = {"2", "5", "9"};
        String q1 = "345";
        String q2 = "239";
        String q3 = "146";
        String q4 = "259";
        PlayResult resut1 = ball.validAnswer(answer,q1);
        PlayResult resut2 = ball.validAnswer(answer,q2);
        PlayResult resut3 = ball.validAnswer(answer,q3);
        PlayResult resut4 = ball.validAnswer(answer,q4);
        assertThat(resut1.getResult()).isEqualTo(new Integer[]{1,0}); // 1볼 0스트라이크
        assertThat(resut2.getResult()).isEqualTo(new Integer[]{0,2}); // 0볼 2스트라이크
        assertThat(resut3.isFourBall()).isEqualTo(true);
        assertThat(resut4.isThreeStrike()).isEqualTo(true);
    }
}