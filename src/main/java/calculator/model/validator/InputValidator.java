package calculator.model.validator;

import calculator.model.Calculator;
import calculator.view.CalculatorView;

import java.util.regex.Pattern;


public class InputValidator {

    public String[] validInput(String input) {
        if (input == null || input.trim().isEmpty()  || input.matches("//.\\\\n?")) {
            return new String[] {"0"};
        }
        String[] parseNumbers = parseInput(input);
        for (String num :parseNumbers) {
            if (!isNumber(num)  || Integer.parseInt(num) < 0) {
                throw new IllegalArgumentException("입력에 숫자가 아닌 값이 포함되어 있습니다.");
            }
        }
        return parseNumbers;
    }

    public String[] parseInput(String input){
        if (input.startsWith("//")) {
            return parseCustom(input);
        } else if (input.matches(".*[:|,].*")){
            return input.split("[:|,]");
        } else if (input.matches("\\d+")) {
            return new String[]{input};
        }else {
            throw new IllegalArgumentException("유효하지 않은 입력 형식입니다.");
        }
    }

    public String[] parseCustom(String input) {
        int splitIndex = input.indexOf("\\n");
        if (splitIndex == -1 || splitIndex == input.length() - 2) {
            throw new IllegalArgumentException("잘못된 형식의 입력입니다. 구분자 형식이 올바르지 않습니다.");
        }

        String delimiter = input.substring(2, splitIndex);
        String numbersPart = input.substring(splitIndex + 2);

        if (delimiter.isEmpty()|| delimiter.matches("\\d+")) {
            throw new IllegalArgumentException("구분자는 숫자가 아닌 문자여야 합니다.");
        }
        if (numbersPart.isEmpty()) {
            throw new IllegalArgumentException("잘못된 형식의 구분자입니다.");
        }

        return numbersPart.split(Pattern.quote(delimiter));
    }


    private boolean isNumber(String num) {
        try {
            Integer.parseInt(num);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }

}
