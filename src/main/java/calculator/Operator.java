package calculator;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+" , Integer::sum),
    MINUS("-"  , (previousValue , nextValue) -> previousValue - nextValue),
    MULTIPLY("*" , (previousValue , nextValue) -> previousValue * nextValue),
    DIVISION("/" , (previousValue , nextValue) -> previousValue / nextValue);

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
}
