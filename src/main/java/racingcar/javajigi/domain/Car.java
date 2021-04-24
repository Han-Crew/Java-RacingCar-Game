package racingcar.javajigi.domain;


import java.util.Random;

public class Car {
    public static final int MAX_BOUND = 10;
    public static final int FORWARD_NUM = 4;
    private final Name name;
    private Position position = new Position();

    public Car(String name) {
        if ("".equals(name)) {
            throw new IllegalArgumentException("자동차는 이름을 갖고 있어야 합니다.");
        }
        this.name = new Name(name);
    }

    public Position getPosition() {
        return position;
    }

    public void move(RandomNumber randomNumber) {
        if (randomNumber.isMovable()) {
            position.move();
        }
    }

    public void move2() {
        if (getRandomNo() >= FORWARD_NUM)
            this.position.move();
    }

    protected int getRandomNo() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }
}
