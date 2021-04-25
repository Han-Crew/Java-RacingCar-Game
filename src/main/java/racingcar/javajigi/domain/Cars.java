package racingcar.javajigi.domain;

import racingcar.javajigi.utils.RandomUtil;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cars {
    private final List<Car> cars;
    private Random random = new Random();
    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveAll() {
        for (Car car : cars) {
            RandomNumber randomNumber = new RandomNumber(RandomUtil.getRandomZeroToNine());
            car.move(randomNumber);
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
