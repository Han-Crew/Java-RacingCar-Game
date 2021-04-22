package racingcar;

public class Game {
    private final int numberOfTry;
    private final CarList carList;

    public Game(int numberOfTry , CarList carList) {
        this.numberOfTry = numberOfTry;
        this.carList = carList;
    }

    public void start() {
        for (int i=0; i<numberOfTry; i++) {
            carList.run();
        }

        result();
    }

    private void result() {
        for (int i=0; i<carList.getCarList().size(); i++) {
            Car car = carList.getCar(i);
            System.out.println(car.gameResult());
        }

        System.out.println(carList.getWinningCars() + "가 최종 우승했습니다.");
    }
}
