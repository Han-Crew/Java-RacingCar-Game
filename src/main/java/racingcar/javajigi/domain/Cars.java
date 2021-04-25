package racingcar.javajigi.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move(new RandomValuedMovingStrategy());
        }
    }

    public Winners findWinner() {
        return filterWinners(getMaxPosition());
    }

    public Winners filterWinners(int maxPosition) {
        Winners winners = new Winners();
        for (Car car : cars) {
            if (car.isWinner(maxPosition)) {
                winners.add(car);
            }
        }

        return winners;
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.max(maxPosition);
        }

        return maxPosition;
    }
}
