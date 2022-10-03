package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballTest {

    ValidationBall validationBall = new ValidationBall();

    @Test
    @DisplayName("각기 다른 3자리 숫자가 랜덤으로 나오게 하기")
    void createAnswerTest() {
        Ball ball = new Ball();
        ball.createAnswer();
        boolean isAnswerValid = validationBall.validNumbers(ball.getNumbers());
        assertThat(ball.getNumbers().length()).isEqualTo(3);
        assertThat(isAnswerValid).isEqualTo(true);
    }

    @Test
    @DisplayName("3자리 숫자 valid 실패한 경우")
    void validNumberIsFalse() {
        Ball ball1 = new Ball("1234");
        Ball ball2 = new Ball("255");
        boolean isAnswerValid1 = validationBall.validNumbers(ball1.getNumbers());
        boolean isAnswerValid2 = validationBall.validNumbers(ball2.getNumbers());
        assertThat(isAnswerValid1).isEqualTo(false);
        assertThat(isAnswerValid2).isEqualTo(false);
    }

    @Test
    @DisplayName("3자리 숫자 입력 후 결과 확인")
    void validAnswerTest() {
        Ball answer = new Ball("259");
        Ball q1 = new Ball("345");
        Ball q2 = new Ball("239");
        Ball q3 = new Ball("146");
        Ball q4 = new Ball("259");
        PlayResult resut1 = validationBall.validAnswer(answer,q1);
        PlayResult resut2 = validationBall.validAnswer(answer,q2);
        PlayResult resut3 = validationBall.validAnswer(answer,q3);
        PlayResult resut4 = validationBall.validAnswer(answer,q4);
        assertThat(resut1.getResult()).isEqualTo(new Integer[]{1,0}); // 1볼 0스트라이크
        assertThat(resut2.getResult()).isEqualTo(new Integer[]{0,2}); // 0볼 2스트라이크
        assertThat(resut3.isFourBall()).isEqualTo(true);
        assertThat(resut4.isThreeStrike()).isEqualTo(true);
    }
}