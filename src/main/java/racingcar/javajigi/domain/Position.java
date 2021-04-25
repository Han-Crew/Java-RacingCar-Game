package racingcar.javajigi.domain;

import java.util.Objects;

public class Position {
    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("포지션은 0이상의 값만 올 수 있습니다.");
        }
        this.position = position;
    }

    public Position move() {
        this.position += 1;
        return this;
    }

    public int getPosition() {
        return position;
    }

    public boolean samePosition(int position) {
        return this.position == position;
    }

    public boolean isGreaterThan(int maxPosition) {
        return this.position > maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
