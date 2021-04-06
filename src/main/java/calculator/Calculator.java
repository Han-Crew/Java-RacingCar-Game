package calculator;

public class Calculator {

    public void validationCheck(String data) {
        if (" ".equals(data) || data == null) {
            throw new IllegalArgumentException("잘못된 값이 넘어왔습니다.");
        }
    }

    public boolean isExists(String symbol) {
        for (Symbol operationSymbol : Symbol.values()) {
            if (operationSymbol.getSymbol().equals(symbol)) {
                return true;
            }
        }

        return false;
    }


    public int toInt(String symbol) {
        return Integer.parseInt(symbol);
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
