package calculator.controller;

import calculator.model.Calculator;
import calculator.model.validator.InputValidator;
import calculator.view.CalculatorView;

public class CalculatorController {
    private final CalculatorView calculatorView;
    private final Calculator calculator;
    private final InputValidator inputValidator;
    public CalculatorController(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
        this.calculator = new Calculator();
        this.inputValidator = new InputValidator();
    }

    public void run() {
        try {
            String input = calculatorView.getInput();
            String[] numbers = inputValidator.validInput(input);
            int result = calculator.calculateSum(numbers);
            calculatorView.printOutput(result);
        } catch (IllegalArgumentException e) {
            calculatorView.printError(e.getMessage());
            throw e;
        }
    }

}
