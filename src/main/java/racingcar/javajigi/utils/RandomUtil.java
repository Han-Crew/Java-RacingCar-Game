package racingcar.javajigi.utils;


import java.util.Random;

public class RandomUtil {
    private static Random random = new Random();

    public static int getRandomZeroToNine() {
        return random.nextInt(10);
    }
}
