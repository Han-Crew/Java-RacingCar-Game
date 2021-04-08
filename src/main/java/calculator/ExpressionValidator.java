package calculator;

public class ExpressionValidator {
    public void validationCheck(String expression) {
        inputDataRegex(expression);

        for (String data : expression.split(" ")) {
            inputDataRegex(data);
        }
    }

    private void inputDataRegex(String data) {
        if (data == null || "".equals(data.trim())) {
            throw new IllegalArgumentException("잘못된 값이 넘어왔습니다.");
        }
    }

    public Operator toEnum(String operator) {
        for (Operator operationOperator : Operator.values()) {
            if (operationOperator.getOperator().equals(operator)) {
                return operationOperator;
            }
        }

        throw new IllegalArgumentException("잘못된 기호입니다.");
    }
}
