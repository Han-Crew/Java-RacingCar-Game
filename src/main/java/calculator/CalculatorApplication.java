package calculator;

import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        Calculator calculator = new Calculator();

        int result = calculator.calculate(expression);
        System.out.println(result);
    }
}
