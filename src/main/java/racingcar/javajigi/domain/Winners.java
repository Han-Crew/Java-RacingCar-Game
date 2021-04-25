package racingcar.javajigi.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> winners = new ArrayList<>();

    public Winners(Winners winners) {
        this.winners = winners;
    }

    public void add(Car car) {
        this.winners.add(car);
    }
}
