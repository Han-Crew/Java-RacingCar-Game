package calculator;

public class Calculator {
    public static final String BLANK = " ";

    private Integer previousValue;
    private Integer nextValue;
    private int result;
    private String operator;

    public Calculator() {
        this.previousValue = null;
        this.nextValue = null;
        this.result = 0;
        this.operator = null;
    }

    public int calculate(String expression) {
        ExpressionValidator.validationCheck(expression);
        for (String data : expression.split(BLANK)) {
            updateOperand(data);
            updateResult();
        }

        return this.result;
    }

    private void updateOperand(String data) {
        try {
            Integer.parseInt(data);
            initializeValueCheck(data);
        } catch (NumberFormatException e) {
            updateOperator(data);
        }
    }

    private void initializeValueCheck(String data) {
        if (previousValue == null && nextValue == null) {
            this.previousValue = toInt(data);
        } else {
            this.nextValue = toInt(data);
        }
    }

    private void updateOperator(String data) {
        this.operator = data;
    }

    private int toInt(String data) {
        return Integer.parseInt(data);
    }

    private void updateResult() {
        if (readyOperation()) {
            Operator operator = Operator.toEnum(this.operator);
            int result = operator.calculate(this.previousValue , this.nextValue);
            this.result = result;
            resetOperatorAndNextValue(result);
        }
    }

    private boolean readyOperation() {
        return this.previousValue != null && this.nextValue != null && this.operator != null;
    }

    private void resetOperatorAndNextValue(int result) {
        this.previousValue = result;
        this.operator = null;
        this.nextValue = null;
    }
}
