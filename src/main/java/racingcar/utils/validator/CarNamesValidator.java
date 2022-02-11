package racingcar.utils.validator;

import java.util.HashSet;
import java.util.Set;

public class CarNamesValidator {

    public static final int CAR_NAME_MAX_LENGTH = 5;
    public static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자 미만이어야 합니다.";
    public static final String CAR_NAME_DUPLICATE_ERROR_MESSAGE = "[ERROR] 자동차 이름은 중복될 수 없습니다.";
    public static final String CAR_NAME_BLANK_ERROR_MESSAGE = "[ERROR] 자동차 이름은 공백이 될 수 없습니다.";

    private static Set<String> carNamesSet;

    private CarNamesValidator() {}

    public static void validateCarNames(final String[] carNames) {
        carNamesSet = new HashSet<>();

        for (String carName : carNames) {
            validateLength(carName);
            validateDuplicate(carName);
            validateBlank(carName);
        }
    }

    private static void validateLength(final String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicate(final String carName) {
        if (carNamesSet.contains(carName)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR_MESSAGE);
        }
        carNamesSet.add(carName);
    }

    private static void validateBlank(final String carName) {
        if ((carName == null) || (carName.length() == 0)) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_ERROR_MESSAGE);
        }
    }
}
