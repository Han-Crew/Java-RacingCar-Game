package racingcar.javajigi.view;

import racingcar.javajigi.domain.TryNo;

import java.util.Scanner;

public class InputView {
    private static Scanner in = new Scanner(System.in);

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        return in.nextLine();
    }

    public static TryNo getTryNo() {
        System.out.println("시도할 횟수는 몇 번 인가요?");
        int tryNo = in.nextInt();
        return new TryNo(tryNo);
    }
}
