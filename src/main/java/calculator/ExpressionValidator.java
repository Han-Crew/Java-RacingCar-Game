package calculator;

public class ExpressionValidator {
    public void validationCheck(String expression) {
        inputDataRegex(expression);

        for (String data : expression.split(" ")) {
            inputDataRegex(data);
        }
    }

    private void inputDataRegex(String data) {
        if (" ".equals(data) || data == null) {
            throw new IllegalArgumentException("잘못된 값이 넘어왔습니다.");
        }
    }

    public Symbol toEnum(String symbol) {
        for (Symbol operationSymbol : Symbol.values()) {
            if (operationSymbol.getSymbol().equals(symbol)) {
                return operationSymbol;
            }
        }

        throw new IllegalArgumentException("잘못된 기호입니다.");
    }
}
