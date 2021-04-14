package calculator;

public class ExpressionValidator {
    public static void validationCheck(String expression) {
        inputDataRegex(expression);

        for (String data : expression.split(" ")) {
            inputDataRegex(data);
        }
    }

    private static void inputDataRegex(String data) {
        if (data == null || "".equals(data.trim())) {
            throw new IllegalArgumentException("잘못된 값이 넘어왔습니다.");
        }
    }
}
