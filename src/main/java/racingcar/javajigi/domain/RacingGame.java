package racingcar.javajigi.domain;

import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int tryNo;

    public void race() {
        this.tryNo--;
        moveCars();
    }

    private void moveCars() {
        for (Car car :  cars) {
//            car.move();
        }
    }

    public boolean racing() {
        return this.tryNo > 0;
    }
}
