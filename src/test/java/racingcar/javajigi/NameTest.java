package racingcar.javajigi;

import org.junit.jupiter.api.Test;
import racingcar.javajigi.domain.Name;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    void invalid() {
        // 분리해도되고 하나로가도 크게 상관 없다.

        assertThatThrownBy(() -> {
            new Name("");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Name("woobeen");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create() {
        Name woo = new Name("woo");
        assertThat(woo).isEqualTo(new Name("woo"));
    }
}
