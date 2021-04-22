package racingcar;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarTest {

    @Nested
    @DisplayName("자동차 이동 테스트")
    class CarMoveTest {
        private Car car;

        @BeforeEach
        public void init() {
            car = new Car("TEST");
        }

        @Test
        public void 값이_4_이상이면_앞으로_한칸_이동() {
            int mockRandomValue = 5;
            car.move(mockRandomValue);

            assertThat(car.getPosition()).isEqualTo(1);
        }

        @Test
        public void 값이_여러번_4_이상이면_앞으로_추가_이동() {
            int mockRandomValue = 5;
            car.move(mockRandomValue);
            car.move(mockRandomValue);
            car.move(mockRandomValue);

            assertThat(car.getPosition()).isEqualTo(3);
        }

        @Test
        public void 값이_4_미만이면_이동하지_않는다() {
            int mockRandomValue = 3;
            car.move(mockRandomValue);

            assertThat(car.getPosition()).isEqualTo(0);
        }

        @Test
        public void 값이_여러번_4_미만이여도_이동하지_않는다() {
            int mockRandomValue = 3;
            car.move(mockRandomValue);
            car.move(mockRandomValue);
            car.move(mockRandomValue);

            assertThat(car.getPosition()).isEqualTo(0);
        }

        @Test
        public void 랜덤값이_0부터_9사이가_아니면_오류발생() {
            int mockRandomValue = 10;

            RuntimeException exception = assertThrows(
                    RuntimeException.class,
                    () -> car.move(mockRandomValue));

            assertThat(exception.getClass()).isEqualTo(IllegalArgumentException.class);
        }

        @Test
        public void 랜덤값이_0부터_9사이가_아니면_오류발생2() {
            int mockRandomValue = -1;

            RuntimeException exception = assertThrows(
                    RuntimeException.class,
                    () -> car.move(mockRandomValue));

            assertThat(exception.getClass()).isEqualTo(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("다수의 자동차 생성 테스트")
    class ManyCarTest {

        @Test
        public void 이름으로_자동차_생성() {
            String carNames = "Car1,Car2,Car3";
            CarList carList = new CarList(carNames);
            assertThat(carList.getCarList().size()).isEqualTo(3);
        }

        @Test
        public void 자동차_이름이_5자이상이면_오류발생() {
            String carNames = "CarName2,Car1,CarNamesIsLong";

            RuntimeException exception = assertThrows(
                    RuntimeException.class,
                    () -> new CarList(carNames));

            assertThat(exception.getClass()).isEqualTo(IllegalArgumentException.class);
        }

        @Test
        public void 자동차_이름에_공백이있으면_오류발생() {
            String carNames = "Car ,Car1,Car2 ";

            RuntimeException exception = assertThrows(
                    RuntimeException.class,
                    () -> new CarList(carNames));

            assertThat(exception.getClass()).isEqualTo(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("자동차 경주 여러번 시도하는 테스트")
    class ManyChallengeTest {

        @Test
        public void 입력한_수만큼_이동_시도() {
            int inputValue = 5;
            int mockRandomValue = 5;

            Car car = new Car("TEST");

            for (int i=0; i<inputValue; i++) {
                car.move(mockRandomValue);
            }

            assertThat(car.getPosition()).isEqualTo(inputValue);
        }
    }
}
