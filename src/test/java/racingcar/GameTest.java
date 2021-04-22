package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Nested
    @DisplayName("게임 결과 테스트")
    class GameResultTest {

        @Test
        public void 자동차이름_AND_이동거리_만큼_출력되야한다_랜덤값은_4이상() {
            String carName = "WOO";
            String expectedResult = carName + ":" + "-----";
            int numberOfTry = 5;
            int randomNumber = 4;

            Car car = new Car(carName);
            for (int i=0; i<numberOfTry; i++) {
                car.move(randomNumber);
            }

            assertThat(car.gameResult()).isEqualTo(expectedResult);
        }

        @Test
        public void 자동차이름_AND_이동거리_만큼_출력되야한다_랜덤값은_4미만() {
            String carName = "WOO";
            String expectedResult = carName + ":" + "";
            int numberOfTry = 5;
            int randomNumber = 3;

            Car car = new Car(carName);
            for (int i=0; i<numberOfTry; i++) {
                car.move(randomNumber);
            }

            assertThat(car.gameResult()).isEqualTo(expectedResult);
        }

        @Test
        public void 이동거리가_가장긴_우승자를_뽑아야한다() {
            String carNames = "Car1,Car2,WIN";
            int numberOfTry = 5;
            CarList carList = new CarList(carNames);

            Car car1 = carList.getCar(0);
            Car car2 = carList.getCar(1);
            Car winCar = carList.getCar(2);

            for (int i=0; i<numberOfTry; i++) {
                car1.move(1);
                car2.move(2);
                winCar.move(4);
            }

            String winningCars = carList.getWinningCars();
            assertThat(winningCars).isEqualTo("WIN");
        }

        @Test
        public void 이동거리가_가장긴_우승자가_여러명인경우() {
            String carNames = "Car1,Car2,WIN,WIN2";
            int numberOfTry = 5;
            CarList carList = new CarList(carNames);

            Car car1 = carList.getCar(0);
            Car car2 = carList.getCar(1);
            Car winCar = carList.getCar(2);
            Car winCar2 = carList.getCar(3);

            for (int i=0; i<numberOfTry; i++) {
                car1.move(1);
                car2.move(2);
                winCar.move(4);
                winCar2.move(4);
            }

            String winningCars = carList.getWinningCars();
            assertThat(winningCars).isEqualTo("WIN,WIN2");
        }
    }
}
