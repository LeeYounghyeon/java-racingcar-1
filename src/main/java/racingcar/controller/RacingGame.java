package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.GameResult;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int MAX_BOUND = 10;

    public static List<Car> makeCarContents() {
        String[] name = InputView.inputName();
        return Arrays.stream(name)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static int inputNumber() {
        return InputView.inputNumber();
    }

    public static void printOneRoundResult(List<Car> cars) {
        for (Car car : cars) {
            car.makeNewCar(getRandomNumber());
        }
    }

    public static List<String> getWinner(List<Car> cars) {
        GameResult gameResult = new GameResult();
        return gameResult.racingResult(cars);
    }

    private static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }
}
