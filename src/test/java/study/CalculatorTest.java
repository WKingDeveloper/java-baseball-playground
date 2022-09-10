package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest extends IOTest{

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void calculatorTest() {
        String formula = "2 + 3 * 4 / 2";
        String formula2 = "1 + 9 / 2 * 3 +";
        String[] formulaSplitArray = scannerStringSplit(formula);
        String[] formulaSplitArray2 = scannerStringSplit(formula2);
        int result = calculator.calculation(formulaSplitArray);
        int result2 = calculator.calculation(formulaSplitArray2);
        assertThat(result).isEqualTo(10);
        assertThat(result2).isEqualTo(15);
    }

    @Test
    @DisplayName("입력한 문자열 분리 테스트")
    void scannerStringSplitTest() {
        String input = "2 + 3";
        String[] result = scannerStringSplit(input);
        String[] expect = {"2","+","3"};
        assertThat(result).isEqualTo(expect);
    }

    String[] scannerStringSplit(String input) {
        systemIn(input);
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");
        return values;
    }


    @Test
    @DisplayName("덧셈 테스트")
    void addTest() {
        int num1 = 9;
        int num2 = 1;
        int result = calculator.add(num1, num2);
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void minusTest() {
        int num1 = 9;
        int num2 = 1;
        int result = calculator.minus(num1, num2);
        assertThat(result).isEqualTo(8);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiplicationTest() {
        int num1 = 9;
        int num2 = 1;
        int result = calculator.multiplication(num1, num2);
        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divisionTest() {
        int num1 = 8;
        int num2 = 2;
        int result = calculator.division(num1, num2);
        assertThat(result).isEqualTo(4);
    }
}
