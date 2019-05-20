package racingcar.view;

import racingcar.constant.MessageConstants;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);


    public static String[] inputName() {
        System.out.println(MessageConstants.INPUT_CARNAME);

        String carNames = SCANNER.nextLine().trim();
        String[] carName = carNames.split(",");

        if (InputValidator.checkCarNameValidate(carNames)) {
            return inputName();
        }

        return carName;
    }

    public static int inputNumber() {
        System.out.println(MessageConstants.INPUT_ROUND);
        String inputNumber = SCANNER.nextLine();

        if (InputValidator.checkNumberValidate(inputNumber)) {
            return inputNumber();
        }

        return Integer.parseInt(inputNumber);
    }
}
