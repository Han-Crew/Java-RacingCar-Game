package racingcar.javajigi.domain;

import java.util.Objects;

public class Name {
    public static final int NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if ("".equals(name)) {
            throw new IllegalArgumentException("자동차는 이름을 갖고 있어야 합니다.");
        }
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5이하여야 합니다.");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
