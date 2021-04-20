package racingcar;

public class Car {
    public static final String MOVE_SYMBOL = "-";
    public static final int MOVE_STANDARD_VALUE = 4;

    private String distance;

    public Car() {
        this.distance = "";
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_STANDARD_VALUE) {
            this.distance = distance + MOVE_SYMBOL;
        }
    }

    public String getDistance() {
        return distance;
    }
}
