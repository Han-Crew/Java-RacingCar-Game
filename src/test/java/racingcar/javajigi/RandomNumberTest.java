package racingcar.javajigi;

import org.junit.jupiter.api.Test;
import racingcar.javajigi.domain.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    @Test
    void create() {
        RandomNumber randomNumber = new RandomNumber(1);
        assertThat(randomNumber).isEqualTo(new RandomNumber(1));
    }
}
