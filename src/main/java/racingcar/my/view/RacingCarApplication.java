package racingcar.my.view;

import racingcar.my.domain.CarList;

import java.util.Scanner;

public class RacingCarApplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.");
        String carNames = in.nextLine();

        System.out.println("시도할 횟수는 몇 번 인가요?");
        int numberOfTry = in.nextInt();

        CarList carList = new CarList(carNames);

        Game game = new Game(numberOfTry , carList);
        game.start();
    }
}
