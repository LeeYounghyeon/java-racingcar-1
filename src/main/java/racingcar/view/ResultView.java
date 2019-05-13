package racingcar.view;

import racingcar.constant.MessageConstants;
import racingcar.controller.RacingGame;
import racingcar.model.Car;

import java.util.List;

public class ResultView {
    public void printGame() {
        List<Car> cars = RacingGame.makeCarContents();
        int number = RacingGame.inputNumber();

        System.out.println("\n" + MessageConstants.RESULT);

        for (int i = 0; i < number; i++) {
            RacingGame.printOneRoundResult(cars);
            printResult(cars);
        }

        printWinner(RacingGame.getWinner(cars));
    }

    public String printHyphen(Car car) {
        return String.format(MessageConstants.RESULT_PRINT_HYPHEN_FORMAT,
                car.getName(), getHyphen(car.getPosition()));
    }

    private void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(printHyphen(car));
        }

        System.out.println();
    }

    private void printWinner(List<String> winners) {
        String winnerResult = String.join(",", winners);
        System.out.println(String.format(MessageConstants.RESULT_PRINT_WINNER_FORMAT, winnerResult));
    }

    private String getHyphen(int position) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }

        return stringBuilder.toString();
    }
}
