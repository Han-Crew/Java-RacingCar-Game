package racingcar.javajigi.domain;

public class TryNo {
    private int tryNo;

    public TryNo(int tryNo) {
        this.tryNo = tryNo;
    }

    public void race() {
        this.tryNo -= 1;
    }

    public boolean racing() {
        return this.tryNo > 0;
    }
}
