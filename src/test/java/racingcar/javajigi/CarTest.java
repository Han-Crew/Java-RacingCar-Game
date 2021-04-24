package racingcar.javajigi;

import org.junit.jupiter.api.Test;
import racingcar.javajigi.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void 이동() {
        Car car = new Car("woo") {
            @Override
            protected int getRandomNo() {
                return 4;
            }
        };
        car.move2();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 정지() {
        Car car = new Car("woo") {
            @Override
            protected int getRandomNo() {
                return 3;
            }
        };
        car.move2();
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
