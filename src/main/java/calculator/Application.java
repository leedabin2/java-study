package calculator;


import calculator.model.Calculator;
import calculator.model.validator.InputValidator;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorView calculatorView = new CalculatorView();
        Calculator calculator = new Calculator();

        InputValidator inputValidator = new InputValidator(calculatorView, calculator);
        int sum = inputValidator.getSumOfValidInput();
        calculatorView.printOutput((long) sum);

    }
}
