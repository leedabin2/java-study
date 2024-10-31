package calculator.model;

import calculator.view.CalculatorView;

import java.util.Arrays;

public class Calculator {

    public int calculateSum(String[] parseNumbers) {
        return Arrays.stream(parseNumbers)
                .mapToInt(Integer::parseInt)
                .sum();

    }
}
