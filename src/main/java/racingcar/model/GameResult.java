package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    public List<String> racingResult(List<Car> cars) {
        int maxDistance = 0;

        maxDistance = getMaxDistance(cars, maxDistance);

        return getWinners(cars, maxDistance);
    }

    public int compareDistance(Car car, int maxDistance) {
        return car.comparePosition(maxDistance);
    }

    protected void checkMaxPosition(Car car, List<String> winners, int maxDistance) {
        String matchName = car.getMatchName(maxDistance);
        if (!matchName.equals("")) {
            winners.add(matchName);
        }
    }

    private List<String> getWinners(List<Car> cars, int maxDistance) {
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            checkMaxPosition(car, winners, maxDistance);
        }

        return winners;
    }

    private int getMaxDistance(List<Car> cars, int maxDistance) {
        for (Car car : cars) {
            maxDistance = compareDistance(car, maxDistance);
        }

        return maxDistance;
    }
}
