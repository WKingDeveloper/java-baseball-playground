package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /**
     * 요구사항 1
     * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     * 힌트
     * 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
     * 배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.
     */

    @Test
    void splitTest() {
        String[] splitTest1 = split("1,2", ",");
        String[] splitTest2 = split("1", ",");
        String[] splitTest1Expect = {"1", "2"};
        String[] splitTest2Expect = {"1"};
        assertThat(splitTest1).isEqualTo(splitTest1Expect);
        assertThat(splitTest2).isEqualTo(splitTest2Expect);
    }

    String[] split(String str,String separator) {
        String[] actual = str.split(separator);
        return actual;
    }

    /**
     * 요구사항 2
     * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
     */

    @Test
    void subStringTest() {
        String string1 = "(1,2)".substring(1, 4);
        assertThat(string1).isEqualTo("1,2");

        String string2 = "(1,2)";
        string2 = string2.substring(1, string2.length() - 1);
        assertThat(string2).isEqualTo("1,2");
    }

    /**
     * 요구사항 3
     * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
     * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
     * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     *
     * Hint
     * import static org.assertj.core.api.Assertions.*;
     *
     * assertThatThrownBy(() -> {
     *     // ...
     * }).isInstanceOf(IndexOutOfBoundsException.class)
     *   .hasMessageContaining("Index: 2, Size: 2");
     */

    @Test
    @DisplayName("charAt Method StringIndexOutOfBoundsException 테스트")
    void charAtTest() {
        String str = "abc";
/*        boolean hasError = false;
        try {
            char c = str.charAt(str.length());

        } catch (StringIndexOutOfBoundsException e) {
            hasError = true;
        }
        assertThat(hasError).isEqualTo(true);*/

        assertThatThrownBy(() -> {
            char c = str.charAt(str.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

    }
}
