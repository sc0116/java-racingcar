package racingcar.utils.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CarNamesValidator {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자 미만이어야 합니다.";
    private static final String CAR_NAME_DUPLICATE_ERROR_MESSAGE = "[ERROR] 자동차 이름은 중복될 수 없습니다.";
    private static final String CAR_NAME_BLANK_ERROR_MESSAGE = "[ERROR] 자동차 이름은 공백이 될 수 없습니다.";

    private CarNamesValidator() {}

    public static void validateDuplicate(final String[] carNames) {
        Set<String> checkedCarNames = new HashSet<>(Arrays.asList(carNames));

        if (checkedCarNames.size() != carNames.length) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validateCarName(final String carName) {
        validateLength(carName);
        validateBlank(carName);
    }

    private static void validateLength(final String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private static void validateBlank(final String carName) {
        if ((carName == null) || (carName.trim().length() == 0)) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_ERROR_MESSAGE);
        }
    }
}
