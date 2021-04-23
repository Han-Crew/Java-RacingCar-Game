package racingcar.my.domain;

import racingcar.my.view.GameStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarList {
    private final List<Car> racingCarList;
    private final Random random = new Random();
    private final List<String> winningCars;

    public CarList(String carNames) {
        winningCars = new ArrayList<>();
        String[] carNameArray = splitCarNames(carNames);
        this.racingCarList = new ArrayList<>(carNameArray.length);
        this.setCarListData(carNameArray);
    }

    private String[] splitCarNames(String carNames) {
        String[] carNameArray = carNames.split(",");
        return carNameArray;
    }

    private void setCarListData(String[] carNameArray) {
        for (int i=0; i<carNameArray.length; i++) {
            Car car = new Car(carNameArray[i]);
            this.racingCarList.add(car);
        }
    }

    public List<Car> getCarList() {
        return racingCarList;
    }

    public void run() {
        for (int i=0; i< racingCarList.size(); i++) {
            int randomNumber = random.nextInt(10);
            racingCarList.get(i).move(randomNumber);
        }
    }

    public Car getCar(int index) {
        return racingCarList.get(index);
    }

    public String getWinningCars() {
        int maximumPosition = getMaximumPosition();
        for (int i=0; i< getCarList().size(); i++) {
            Car car = getCar(i);
            compareMaximumPosition(maximumPosition , car);
        }

        return GameStringUtils.getWinningCarsToString(winningCars);
    }

    private int getMaximumPosition() {
        int position = getCar(0).getPosition();
        for (int i=0; i<getCarList().size(); i++) {
            position = getComparedMaxPosition(position , getCar(i).getPosition());
        }

        return position;
    }

    private int getComparedMaxPosition(int position , int nextPosition) {
        if (position < nextPosition) {
            position = nextPosition;
        }

        return position;
    }

    private void compareMaximumPosition(int maximumPosition , Car car) {
        if (car.isEqualsPosition(maximumPosition)) {
            winningCars.add(car.getName());
        }
    }
}
