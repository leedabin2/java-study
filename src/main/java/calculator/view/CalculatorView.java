package calculator.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class CalculatorView {

    Scanner scanner = new Scanner(System.in);
    public String getInput() {
        System.out.println("문자열을 입력하세요 : ");
        return scanner.nextLine();
    }

    public void printOutput(Long result) {
        System.out.println("결과 : " + result);
    }

}
