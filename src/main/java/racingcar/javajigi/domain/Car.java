package racingcar.javajigi.domain;


import java.util.Objects;
import java.util.Random;

public class Car {
    public static final int MAX_BOUND = 10;
    public static final int FORWARD_NUM = 4;
    private final Name name;
    private Position position = new Position();

    public Car(final String name) {
        this(name , 0);
    }

    public Car(final String name , int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Position getPosition() {
        return position;
    }

    public void move(RandomNumber randomNumber) {
        if (randomNumber.isMovable()) {
            position.move();
        }
    }

    public boolean isWinner(int maxPosition) {
        return position.samePosition(maxPosition);
    }

    public int max(int maxPosition) {
        if (position.isGreaterThan(maxPosition)) {
            return position.getPosition();
        }

        return maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
