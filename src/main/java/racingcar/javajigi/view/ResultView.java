package racingcar.javajigi.view;

import racingcar.javajigi.domain.*;

public class ResultView {
    public static void printCars(Cars cars) {
        for (Car car : cars.getCars()) {
            Name name = car.getName();
            String moveDistance = createMoveDistance(car.getPosition());

            System.out.println(name + " : " + moveDistance);
        }
    }

    private static String createMoveDistance(Position position) {
        String distance = "";
        for (int i=0; i<position.getPosition(); i++) {
            distance += "-";
        }

        return distance;
    }


    public static void printWinners(Winners winners) {
        String winnersName = "";
        for (Car car : winners.getWinners()) {
            winnersName += car.getName() + ",";
        }

        System.out.println(winnersName.substring(0 , winnersName.length() - 1));
    }
}
