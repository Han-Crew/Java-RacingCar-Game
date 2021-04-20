package racingcar;

import java.util.Scanner;

public class RacingCarApplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = in.nextInt();

        System.out.println("시도할 횟수는 몇 번 인가요?");
        int challengeCount = in.nextInt();

        CarList carList = new CarList(carCount);
        Game game = new Game(challengeCount , carList);
        game.start();

        game.result();
    }
}
