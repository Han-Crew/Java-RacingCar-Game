package calculator;

public class ExpressionOrder {
    private ExpressionType expressionType;

    public ExpressionOrder() {
        this.expressionType = ExpressionType.NUMBER;
    }

    public ExpressionType getExpressionType() {
        return expressionType;
    }

    public void toggle() {
        if (this.expressionType.equals(ExpressionType.NUMBER)) {
            expressionType = ExpressionType.SYMBOL;
        } else {
            expressionType = ExpressionType.NUMBER;
        }
    }

    enum ExpressionType {
        NUMBER,
        SYMBOL;
    }
}
