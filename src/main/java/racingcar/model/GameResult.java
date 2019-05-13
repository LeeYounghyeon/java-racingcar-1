package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    public static List<String> racingResult(List<Car> cars) {
        int maxDistance = 0;

        maxDistance = getMaxDistance(cars, maxDistance);

        return getWinners(cars, maxDistance);
    }

    public static int compareDistance(Car car, int maxDistance) {
        return car.comparePosition(maxDistance);
    }

    public static void checkMaxPosition(Car car, List<String> winners, int maxDistance) {
        if (!car.matchPosition(maxDistance).equals("")) {
            winners.add(car.matchPosition(maxDistance));
        }
    }

    private static List<String> getWinners(List<Car> cars, int maxDistance) {
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            checkMaxPosition(car, winners, maxDistance);
        }

        return winners;
    }

    private static int getMaxDistance(List<Car> cars, int maxDistance) {
        for (Car car : cars) {
            maxDistance = compareDistance(car, maxDistance);
        }

        return maxDistance;
    }
}
