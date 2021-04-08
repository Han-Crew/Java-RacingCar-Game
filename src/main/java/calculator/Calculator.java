package calculator;

public class Calculator {
    private int previousValue;
    private int nextValue;
    private int result;
    private String operator;
    private final ExpressionValidator validator;

    public Calculator() {
        this.previousValue = 0;
        this.nextValue = 0;
        this.result = 0;
        this.operator = null;
        this.validator = new ExpressionValidator();
    }

    public int calculate(String expression) {
        validator.validationCheck(expression);
        for (String data : expression.split(" ")) {
            updateOperand(data);
            updateResult();
        }

        return this.result;
    }

    private void updateOperand(String data) {
        if (!isNumber(data)) {
            operator = data;
        } else {
            if (previousValue == 0 && nextValue == 0) {
                this.previousValue = toInt(data);
            } else {
                this.nextValue = toInt(data);
            }
        }
    }

    private boolean isNumber(String data) {
        try {
            Integer.parseInt(data);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private int toInt(String data) {
        return Integer.parseInt(data);
    }

    private void updateResult() {
        if (readyOperation()) {
            Operator operator = validator.toEnum(this.operator);
            int result = operator.calculate(this.previousValue , this.nextValue);
            this.result = result;
            resetOperatorAndNextValue(result);
        }
    }

    private boolean readyOperation() {
        return this.previousValue != 0 && this.nextValue != 0 && this.operator != null;
    }

    private void resetOperatorAndNextValue(int result) {
        this.previousValue = result;
        this.operator = null;
        this.nextValue = 0;
    }
}
