package study;

import java.util.Scanner;

public class Calculator {

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    public int multiplication(int num1, int num2) {
        return num1*num2;
    }

    public int division(int num1, int num2) {
        return num1/num2;
    }

    public String[] scannerSplit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("계산식을 입력해주세요.");
        String value = scanner.nextLine();
        String[] values = value.split(" ");
        return values;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.scannerSplit();
    }

    public int calculation(String[] input) {

        int result = stringToIntParser(input[0]);
//        size =8
//        index 0~7
//        0,2,4,6,8
        for (int i = 0; i< input.length-1; i+=2) {
            if (i+2==input.length) {
                break;
            }
            switch (input[i+1]) {
                case "+":
                    result = add(result,stringToIntParser(input[i+2]));
                    break;
                case "-":
                    result = minus(result,stringToIntParser(input[i+2]));
                    break;
                case "*":
                    result = multiplication(result,stringToIntParser(input[i+2]));
                    break;
                case "/":
                    result = division(result,stringToIntParser(input[i+2]));
            }
        }
        return result;
    }

    private int stringToIntParser(String stringNum) {
        return Integer.valueOf(stringNum);
    }
}
