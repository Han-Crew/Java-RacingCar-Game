package racingcar.javajigi.domain;


import java.util.Random;

public class Car {
    public static final int MAX_BOUND = 10;
    public static final int FORWARD_NUM = 4;
    private String name;
    private int position = 0;

    public Car(String name) {
        if ("".equals(name)) {
            throw new IllegalArgumentException("자동차는 이름을 갖고 있어야 합니다.");
        }
        this.name = name.trim();
    }

    public void move() {
        if (getRandomNo() >= FORWARD_NUM)
            this.position++;
    }

    public int getPosition() {
        return position;
    }

    protected int getRandomNo() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }
}
