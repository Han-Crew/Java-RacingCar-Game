package racingcar.javajigi.domain;

import java.util.Objects;

import static racingcar.javajigi.domain.Car.FORWARD_NUM;

public class RandomNumber {
    private final int randomNo;

    public RandomNumber(int randomNo) {
        if (randomNo < 1 || randomNo > 9) {
            throw new IllegalArgumentException("랜덤 숫자는 0 부터 9 사이의 숫자만 올 수 있습니다.");
        }

        this.randomNo = randomNo;
    }

    public boolean isMovable() {
        return this.randomNo > FORWARD_NUM;
    }

    public int getRandomNo() {
        return randomNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomNumber that = (RandomNumber) o;
        return randomNo == that.randomNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(randomNo);
    }
}
