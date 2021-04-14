package calculator;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+" , Integer::sum),
    MINUS("-" , (previousValue, nextValue) -> previousValue - nextValue),
    MULTIPLY("*" , (previousValue , nextValue) -> previousValue * nextValue),
    DIVISION("/" , (previousValue , nextValue) -> {
        divisionValidationCheck(nextValue);
        return previousValue / nextValue;
    });

    private String operator;
    private BiFunction<Integer , Integer , Integer> calculate;

    Operator(String operator , BiFunction<Integer , Integer , Integer> calculate) {
        this.operator = operator;
        this.calculate = calculate;
    }

    public String getOperator() {
        return operator;
    }

    public int calculate(int previousValue , int nextValue) {
        return calculate.apply(previousValue , nextValue);
    }

    public static Operator toEnum(String operator) {
        for (Operator operationOperator : Operator.values()) {
            if (operationOperator.getOperator().equals(operator)) {
                return operationOperator;
            }
        }

        throw new IllegalArgumentException("잘못된 기호입니다.");
    }

    private static void divisionValidationCheck(int divisionValue) {
        if (divisionValue == 0) {
            throw new IllegalArgumentException("0으로 나눌수 없습니다.");
        }
    }
}
