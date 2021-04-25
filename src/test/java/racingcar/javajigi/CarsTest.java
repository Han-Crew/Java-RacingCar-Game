package racingcar.javajigi;

import org.junit.jupiter.api.Test;
import racingcar.javajigi.domain.Car;
import racingcar.javajigi.domain.Cars;
import racingcar.javajigi.domain.Winners;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void findCars() {
        Cars cars = new Cars(
                List.of(
                    new Car("pobi" , 5),
                    new Car("crong" , 4),
                    new Car("honux" , 5)
                )
        );

        Winners winners = cars.findWinner();
        assertThat(winners.getWinners()).contains(
                new Car("pobi" , 5),
                new Car("honux" , 5)
        );
    }
}
