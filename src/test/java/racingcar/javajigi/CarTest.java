package racingcar.javajigi;

import org.junit.jupiter.api.Test;
import racingcar.javajigi.domain.Car;
import racingcar.javajigi.domain.Position;
import racingcar.javajigi.domain.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void 이동() {
        Car car = new Car("woo");
        RandomNumber randomNumber = new RandomNumber(5);
        car.move(randomNumber);

        Position comparePosition = new Position(1);
        assertThat(car.getPosition()).isEqualTo(comparePosition);
    }

    @Test
    public void 정지() {
        Car car = new Car("woo");
        RandomNumber randomNumber = new RandomNumber(1);
        car.move(randomNumber);

        Position comparePosition = new Position(0);
        assertThat(car.getPosition()).isEqualTo(comparePosition);
    }
}
