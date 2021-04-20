package racingcar;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Nested
    @DisplayName("자동차 이동 테스트")
    class CarMoveTest {
        private Car car;

        @BeforeEach
        public void init() {
            car = new Car();
        }

        @Test
        public void 값이_4_이상이면_앞으로_한칸_이동() {
            int mockRandomValue = 5;
            car.move(mockRandomValue);

            assertThat(car.getDistance()).isEqualTo("-");
        }

        @Test
        public void 값이_여러번_4_이상이면_앞으로_추가_이동() {
            int mockRandomValue = 5;
            car.move(mockRandomValue);
            car.move(mockRandomValue);
            car.move(mockRandomValue);

            assertThat(car.getDistance()).isEqualTo("---");
        }

        @Test
        public void 값이_4_미만이면_이동하지_않는다() {
            int mockRandomValue = 3;
            car.move(mockRandomValue);

            assertThat(car.getDistance()).isEqualTo("");
        }

        @Test
        public void 값이_여러번_4_미만이여도_이동하지_않는다() {
            int mockRandomValue = 3;
            car.move(mockRandomValue);
            car.move(mockRandomValue);
            car.move(mockRandomValue);

            assertThat(car.getDistance()).isEqualTo("");
        }
    }

    @Nested
    @DisplayName("다수의 자동차 이동 테스트")
    class ManyCarTest {

        @Test
        public void 입력한_수만큼의_자동차_생성() {
            int inputValue = 3;
            CarList carList = new CarList(inputValue);

            System.out.println(carList.getCarList().size());
            assertThat(carList.getCarList().size()).isEqualTo(inputValue);
        }
    }

    @Nested
    @DisplayName("자동차 경주 여러번 시도하는 테스트")
    class ManyChallengeTest {

        @Test
        public void 입력한_수만큼_이동_시도() {
            int inputValue = 5;
            int mockRandomValue = 5;

            Car car = new Car();
            String distance = "";

            for (int i=0; i<inputValue; i++) {
                car.move(mockRandomValue);
                distance = distance + "-";
            }

            assertThat(car.getDistance()).isEqualTo(distance);
        }

        @Test
        void ranTest() {
            Random rand = new Random();

            for (int i=0; i<30; i++) {
                System.out.println(rand.nextInt(10));
//                System.out.println((int) ((Math.random() * 9) + 1));
            }
        }
    }
}
