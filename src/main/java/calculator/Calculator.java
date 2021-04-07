package calculator;


public class Calculator {
    private int previousValue;
    private int nextValue;
    private int totalValue;
    private String symbol;
    private final ExpressionValidator validator;

    public Calculator() {
        this.previousValue = 0;
        this.nextValue = 0;
        this.totalValue = 0;
        this.symbol = null;
        this.validator = new ExpressionValidator();
    }

    public int calculation(String expression) {
        validator.validationCheck(expression);
        for (String data : expression.split(" ")) {
            if (readyOperation()) {
                this.totalValue = totalValue + calc();
            }

            if (!isNumber(data)) {
                symbol = data;
            } else {
                if (previousValue == 0) {
                    this.nextValue = toInt(data);
                } else {
                    this.previousValue = toInt(data);
                }
            }
        }

        return this.totalValue;
    }

    private int calc() {
        Symbol symbol = validator.toEnum(this.symbol);
        int result = symbol.calculate(this.previousValue , this.nextValue);

        clear();
        return result;
    }

    private void clear() {
        this.symbol = null;
        this.nextValue = 0;
    }

    private boolean readyOperation() {
        return this.previousValue != 0 && this.nextValue != 0 && this.symbol != null;
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
}
