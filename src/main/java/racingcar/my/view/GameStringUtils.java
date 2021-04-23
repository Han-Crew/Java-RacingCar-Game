package racingcar.my.view;

import java.util.List;

public class GameStringUtils {
    public static String getWinningCarsToString(List<String> winningCars) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0; i< winningCars.size(); i++) {
            stringBuffer.append(winningCars.get(i));
            stringBuffer.append(",");
        }

        String result = stringBuffer.toString();
        return result.substring(0 , result.length() - 1);
    }
}
