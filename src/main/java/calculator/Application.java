package calculator;


import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.validator.InputValidator;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorView calculatorView = new CalculatorView();
        CalculatorController calculatorController = new CalculatorController(calculatorView);
        calculatorController.run();
    }
}
