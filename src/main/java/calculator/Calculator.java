package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static final String BLANK = " ";

    private int result;
    private List<Integer> numbers = new ArrayList<>();
    private List<Operator> operatorList = new ArrayList<>();

    public int calculate(String expression) {
        ExpressionValidator.validationCheck(expression);
        initializeExpressionData(expression);
        return expressionResult();
    }

    private void initializeExpressionData(String expression) {
        for (String data : expression.split(BLANK)) {
            updateExpressionData(data);
        }
    }

    private void updateExpressionData(String data) {
        try {
            int number = Integer.parseInt(data);
            numbers.add(number);
        } catch (NumberFormatException e) {
            operatorList.add(Operator.toEnum(data));
        }
    }

    private int expressionResult() {
        result = this.numbers.get(0);

        for (int i = 0; i < this.operatorList.size(); i++) {
            result = calculation(result, this.operatorList.get(i), this.numbers.get(i + 1));
        }

        return result;
    }

    private int calculation(int previousValue , Operator operator , int nextValue) {
        return operator.calculate(previousValue , nextValue);
    }
}
