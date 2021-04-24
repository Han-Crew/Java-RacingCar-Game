package racingcar.my;

import org.junit.jupiter.api.Test;
import racingcar.javajigi.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    void move() {
        Position source = new Position(1);
        Position target = source.move();
        assertThat(target).isEqualTo(new Position(2));
    }

    @Test
    void create() {
        Position position = new Position(1);
        assertThat(position).isEqualTo(new Position(1));
    }
}
