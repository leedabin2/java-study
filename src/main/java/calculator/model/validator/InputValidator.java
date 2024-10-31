package calculator.model.validator;

import calculator.model.Calculator;
import calculator.view.CalculatorView;


public class InputValidator {
    private CalculatorView calculatorView;
    private Calculator calculator;
    public InputValidator(CalculatorView calculatorView, Calculator calculator) {
        this.calculatorView = calculatorView;
        this.calculator = calculator;
    }

    public String[] validInput() {
        String input = calculatorView.getInput();
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비었습니다.");
        }
        String[] parseNumbers = parseInput(input);
        for (String num :parseNumbers) {
            if (!isNumber(num)  || Integer.parseInt(num) < 0) {
                throw new IllegalArgumentException("입력에 숫자가 아닌 값이 포함되어 있습니다");
            }
        }
        return parseNumbers;
    }

    public String[] parseInput(String input){
        if (input.startsWith("//")) {
            return parseCustom(input);
        } else if (input.matches(".*[:|,].*")){
            return input.split("[:|,]");
        } else {
            throw new IllegalArgumentException("유효하지 않은 입력 형식입니다.");
        }
    }

    public String[] parseCustom(String input) {

        int splitIndex = input.indexOf("\\n");;
        if (splitIndex == -1) {
            throw new IllegalArgumentException("잘못된 형식의 입력입니다. 구분자 형식이 올바르지 않습니다.");
        }
        String delimiter = input.substring(2, splitIndex);
        String numbersPart = input.substring(splitIndex + 2);
        return numbersPart.split(delimiter);
    }


    private boolean isNumber(String num) {
        try {
            Integer.parseInt(num);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }

    public int getSumOfValidInput() {
        String[] parseNumbers = validInput();
        return calculator.calculateSum(parseNumbers);
    }




}
