package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballTest {

    Baseball baseball = new Baseball();


    @Test
    @DisplayName("각기 다른 3자리 숫자가 랜덤으로 나오게 하기")
    void createAnswerTest() {
        Integer[] result = baseball.createAnswer();
        boolean isAnswerValid = baseball.validNumbers(result);
        String resultToString = Arrays.toString(result);
        System.out.println(resultToString);
        assertThat(result.length).isEqualTo(3);
        assertThat(isAnswerValid).isEqualTo(true);
    }

    @Test
    @DisplayName("3자리 숫자 valid 실패한 경우")
    void isAnswerValidFalse() {
        Integer[] result1 = {1, 2, 3, 4};
        Integer[] result2 = {2, 5, 5};
        boolean isAnswerValid1 = baseball.validNumbers(result1);
        boolean isAnswerValid2 = baseball.validNumbers(result2);
        assertThat(isAnswerValid1).isEqualTo(false);
        assertThat(isAnswerValid2).isEqualTo(false);
    }
}