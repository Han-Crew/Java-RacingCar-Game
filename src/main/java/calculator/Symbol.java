package calculator;

import java.util.function.BiFunction;

public enum Symbol {
    PLUS("+" , Integer::sum),
    MINUS("-"  , (x , y) -> x - y),
    MULTIPLY("*" , (x , y) -> x * y),
    DIVISION("/" , (x , y) -> x / y);

    private String symbol;
    private BiFunction<Integer , Integer , Integer> calculate;

    Symbol(String symbol , BiFunction<Integer , Integer , Integer> calculate) {
        this.symbol = symbol;
        this.calculate = calculate;
    }

    public String getSymbol() {
        return symbol;
    }

    public int calculate(int x , int y) {
        return calculate.apply(x , y);
    }
}
