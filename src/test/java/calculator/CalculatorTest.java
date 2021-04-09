package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private static final int PREVIOUS_VALUE = 20;
    private static final int NEXT_VALUE = 10;
    private ExpressionValidator validator;
    private Calculator calculator;

    @BeforeEach
    void init() {
        validator = new ExpressionValidator();
        calculator = new Calculator();
    }

    @Nested
    @DisplayName("계산 테스트")
    class CalculatorOperatorTest {

        @Test
        public void 더하기_테스트() {
            Operator operator = validator.toEnum("+");
            assertThat(operator.calculate(PREVIOUS_VALUE , NEXT_VALUE)).isEqualTo(30);
        }

        @Test
        public void 빼기_테스트() {
            Operator operator = validator.toEnum("-");
            assertThat(operator.calculate(PREVIOUS_VALUE , NEXT_VALUE)).isEqualTo(10);
        }

        @Test
        public void 곱하기_테스트() {
            Operator operator = validator.toEnum("*");
            assertThat(operator.calculate(PREVIOUS_VALUE , NEXT_VALUE)).isEqualTo(200);
        }

        @Test
        public void 나누기_테스트() {
            Operator operator = validator.toEnum("/");
            assertThat(operator.calculate(PREVIOUS_VALUE , NEXT_VALUE)).isEqualTo(2);
        }
    }

    @Nested
    @DisplayName("계산기 오류 테스트")
    class CalculatorExceptionTest {

        @Test
        public void 연산값_유효성_체크_테스트() {
            String 널_VALUE = null;
            String 빈_공백 = " ";

            RuntimeException 널값을_넘긴_경우 = assertThrows(
                    RuntimeException.class,
                    () -> calculator.calculate(널_VALUE));

            assertThat(널값을_넘긴_경우.getClass()).isEqualTo(IllegalArgumentException.class);


            RuntimeException 공백을_넘긴_경우 = assertThrows(
                    IllegalArgumentException.class,
                    () -> calculator.calculate(빈_공백));

            assertThat(공백을_넘긴_경우.getClass()).isEqualTo(IllegalArgumentException.class);
        }

        @Test
        public void 심볼_ENUM타입_체크_테스트() {
            String wrongOperator = "&";

            RuntimeException exception = assertThrows(
                    RuntimeException.class,
                    () -> validator.toEnum(wrongOperator));

            assertThat(exception.getClass()).isEqualTo(IllegalArgumentException.class);
        }

        @Test
        public void 계산식의_공백문자열이_잘못된_경우() {
            String expression = "5  *  2 + 2 / 2";

            RuntimeException exception = assertThrows(
                    RuntimeException.class,
                    () -> validator.validationCheck(expression));

            assertThat(exception.getClass()).isEqualTo(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("통합 계산 테스트")
    class CalculatorOperationTest {

        @Test
        public void 사칙연산_테스트() {
            String expression = "3 + 2 * 3 / 5";
            assertThat(calculator.calculate(expression)).isEqualTo(3);
        }

        @Test
        public void 사칙연산_테스트2() {
            String expression = "5 * 2 + 2 / 2";
            assertThat(calculator.calculate(expression)).isEqualTo(6);
        }

        @Test
        public void 사칙연산_테스트3() {
            String expression = "5 * 5 / 2";
            assertThat(calculator.calculate(expression)).isEqualTo(12);
        }

        @Test
        public void 사칙연산_테스트4() {
            String expression = "5 * 5 / 5 / 5";
            assertThat(calculator.calculate(expression)).isEqualTo(1);
        }
    }
}
