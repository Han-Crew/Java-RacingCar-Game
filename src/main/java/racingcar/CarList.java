package racingcar;

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
        this.setCarList(carNameArray);
    }

    private String[] splitCarNames(String carNames) {
        String[] carNameArray = carNames.split(",");
        return carNameArray;
    }

    private void setCarList(String[] carNameArray) {
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
            if (maximumPosition == car.getPosition()) {
                winningCars.add(car.getName());
            }
        }

        return getWinningCarsToString(winningCars);
    }

    private String getWinningCarsToString(List<String> winningCars) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0; i< winningCars.size(); i++) {
            stringBuffer.append(winningCars.get(i));
            stringBuffer.append(",");
        }

        String result = stringBuffer.toString();
        return result.substring(0 , result.length() - 1);
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
}
