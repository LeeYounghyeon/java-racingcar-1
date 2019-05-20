package racingcar.view;

import racingcar.constant.MessageConstants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final int MINIMUM_PLAYER = 1;
    private static final int NAME_LENGTH = 5;
    private static final Pattern PATTERN = Pattern.compile("^[0-9]$");

    public static boolean checkCarNameValidate(String carNames) {
        String[] carName = carNames.split(",");

        if (overLengthName(carName)) return true;
        if (hasBlank(carNames)) return true;
        if (hasNotAnotherPlayer(carName)) return true;
        if (overLapName(carName)) return true;

        return hasMiddleBlank(carName);
    }

    public static boolean checkNumberValidate(String inputNumber) {
        if (hasBlank(inputNumber)) return true;
        if (hasCharacter(inputNumber)) return true;

        return hasNegativeNumber(inputNumber);
    }

    private static boolean hasBlank(String carNames) {
        if (carNames.isEmpty()) {
            System.err.println(MessageConstants.ERROR_EMPTY);
            return true;
        }
        return false;
    }

    private static boolean overLengthName(String[] carName) {
        if (Arrays.stream(carName).anyMatch(name -> name.length() >= NAME_LENGTH)) {
            System.err.println(MessageConstants.ERROR_OVERLENGTH);
            return true;
        }

        return false;
    }

    private static boolean hasNotAnotherPlayer(String[] carName) {
        if (carName.length == MINIMUM_PLAYER) {
            System.err.println(MessageConstants.ERROR_PLAYER_NUMBER);
            return true;
        }
        return false;
    }

    private static boolean overLapName(String[] carName) {
        Set<String> compareName = new HashSet<>(Arrays.asList(carName));

        if (carName.length != compareName.size()) {
            System.err.println(MessageConstants.ERROR_DUPLICATE_NAME);
            return true;
        }
        return false;
    }

    private static boolean hasMiddleBlank(String[] carNames) {
        long emptyNameCount = Arrays.stream(carNames)
                .map(c -> c.replace(" ", ""))
                .filter(String::isEmpty).count();

        if (emptyNameCount > 0) {
            System.err.println(MessageConstants.ERROR_CONTAIN_EMPTY);
            return true;
        }

        return false;
    }

    private static boolean hasNegativeNumber(String inputNumber) {
        if (Integer.parseInt(inputNumber) <= 0) {
            System.err.println(MessageConstants.ERROR_MINUS_NUMBER);
            return true;
        }

        return false;
    }

    private static boolean hasCharacter(String inputNumber) {
        char[] inputChar = inputNumber.toCharArray();
        Matcher matcher = PATTERN.matcher(inputNumber);

        if (inputChar[0] == '-') {
            return false;
        }
        if (!matcher.find()) {
            System.err.println(MessageConstants.ERROR_INPUT_CHAR);
            return true;
        }

        return false;
    }
}
