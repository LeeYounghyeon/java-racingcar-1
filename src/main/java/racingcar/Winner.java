package racingcar;

import java.util.List;

public class Winner {
    public static MovedCar findWinner(List<MovedCar> cars) {
        int max = getMax(cars);

        return getWinner(cars, max);
    }

    private static MovedCar getWinner(List<MovedCar> cars, int max) {
        for (MovedCar car : cars) {
            if (car.hasMax(max)) {
                return car;
            }
        }
        return cars.get(0);
    }

    private static int getMax(List<MovedCar> cars) {
        int max = 0;

        for (MovedCar car : cars) {
            if (car.getMax(max)) {
                max = car.getPosition();
            }
        }
        return max;
    }
}
