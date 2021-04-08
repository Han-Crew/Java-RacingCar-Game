package calculator;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+" , Integer::sum),
    MINUS("-"  , (x , y) -> x - y),
    MULTIPLY("*" , (x , y) -> x * y),
    DIVISION("/" , (x , y) -> x / y);

    private String operator;
    private BiFunction<Integer , Integer , Integer> calculate;

    Operator(String operator , BiFunction<Integer , Integer , Integer> calculate) {
        this.operator = operator;
        this.calculate = calculate;
    }

    public String getOperator() {
        return operator;
    }

    public int calculate(int x , int y) {
        return calculate.apply(x , y);
    }
}
