package utils;

import dto.Balls;
import enums.GameEndStatus;

public final class ValidationUtils{

    public static void validateBalls(Balls balls) throws Exception {
        if (balls.getSize()!=3) {
            throw new Exception("중복되지 않은 숫자 3개가 아닙니다.");
        }
    }

    public static void validateGameEnd(String gameEnd) throws Exception {
        if (GameEndStatus.isValid(gameEnd)) {
            throw new Exception(gameEnd+" : 유효한 값이 아닙니다.");
        }
    }
}
