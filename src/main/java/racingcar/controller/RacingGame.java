package racingcar.controller;

import racingcar.constant.MessageConstants;
import racingcar.model.Car;
import racingcar.model.GameResult;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private final int MAX_BOUND = 10;

    public void run() {
        List<Car> cars = makeCarContents();
        int number = inputNumber();

        System.out.println("\n" + MessageConstants.RESULT);

        for (int i = 0; i < number; i++) {
            printOneRoundResult(cars);
        }

        ResultView.printWinner(getWinner(cars));
    }

    private List<Car> makeCarContents() {
        String[] name = InputView.inputName();
        return Arrays.stream(name)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int inputNumber() {
        return InputView.inputNumber();
    }

    private void printOneRoundResult(List<Car> cars) {
        for (Car car : cars) {
            car.makeNewCar(getRandomNumber());
        }
        ResultView.printResult(cars);
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

    private List<String> getWinner(List<Car> cars) {
        return GameResult.racingResult(cars);
    }

}
