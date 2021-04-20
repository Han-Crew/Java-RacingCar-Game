package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarList {
    private final List<Car> racingCarList;
    private final Random random = new Random();

    public CarList(int count) {
        this.racingCarList = new ArrayList<>(count);
        for (int i=0; i<count; i++) {
            this.racingCarList.add(new Car());
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
}
