package racingcar.javajigi.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private Cars cars;
    private TryNo tryNo;

    public RacingGame(String carNames , TryNo tryNo) {
        this.cars = new Cars(initCars(carNames));
        this.tryNo = tryNo;
    }

    private static List<Car> initCars(String carNames) {
        if ("".equals(carNames)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }

        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public void race() {
        tryNo.race();
        moveCars();
    }

    private void moveCars() {
        this.cars.moveAll();
    }

    public boolean racing() {
        return tryNo.racing();
    }

    public Cars getCars() {
        return this.cars;
    }

    public Winners getWinners() {
        return cars.findWinner();
    }
}
