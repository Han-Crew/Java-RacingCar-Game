package racingcar;

public class Game {
    private final int challengeCount;
    private final CarList carList;

    public Game(int challengeCount , CarList carList) {
        this.challengeCount = challengeCount;
        this.carList = carList;
    }

    public void start() {
        for (int i=0; i<challengeCount; i++) {
            carList.run();
        }
    }

    public void result() {
        for (int i=0; i<carList.getCarList().size(); i++) {
            Car car = carList.getCar(i);
            System.out.println(car.getDistance());
        }
    }
}
