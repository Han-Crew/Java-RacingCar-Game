package racingcar.javajigi.view;

import racingcar.javajigi.domain.RacingGame;
import racingcar.javajigi.domain.TryNo;

public class RacingMain {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        TryNo tryNo = InputView.getTryNo();

        RacingGame racingGame = new RacingGame(carNames , tryNo);
        while (racingGame.racing()) {
            racingGame.race();
        }

        ResultView.printCars(racingGame.getCars());
        ResultView.printWinners(racingGame.getWinners());
    }
}
