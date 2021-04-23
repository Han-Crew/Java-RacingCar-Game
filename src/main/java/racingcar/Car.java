package racingcar;

public class Car {
    public static final String MOVE_SYMBOL = "-";
    public static final int MOVE_STANDARD_VALUE = 4;
    public static final String CAR_NAME_LENGTH_EXCEPTION = "자동차 이름은 5글자를 넘을 수 없습니다.";
    public static final String CAR_NAME_BLANK_EXCEPTION = "자동차 이름에는 공백이 올 수 없습니다.";
    public static final String RANDOM_NUMBER_RANGE_EXCEPTION = "랜덤값은 0 부터 9 사이의 값만 올 수 있습니다.";

    private String name;
    private int position;

    public Car(String name) {
        this.validationCarName(name);
        this.name = name;
        this.position = 0;
    }


    private void validationCarName(String name) {
        carNameBlankCheck(name);
        this.carNameLengthCheck(name);
    }

    private void carNameBlankCheck(String name) {
        if (name.indexOf(" ") > -1) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_EXCEPTION);
        }
    }

    private void carNameLengthCheck(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION);
        }
    }

    public void move(int randomNumber) {
        this.randomNumberCheck(randomNumber);
        if (randomNumber >= MOVE_STANDARD_VALUE) {
            this.position++;
        }
    }

    private void randomNumberCheck(int randomNumber) {
        if (randomNumber < 0 || randomNumber > 9) {
            throw new IllegalArgumentException(RANDOM_NUMBER_RANGE_EXCEPTION);
        }
    }

    public String gameResult() {
        StringBuffer result = new StringBuffer();
        result.append(name);
        result.append(":");
        for (int i=0; i<position; i++) {
            result.append(MOVE_SYMBOL);
        }

        return result.toString();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
