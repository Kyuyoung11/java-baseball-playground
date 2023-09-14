package enums;

import java.util.Arrays;

public enum GameEndStatus {

    RESTART("1"),
    END("2");

    private final String value;

    GameEndStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isGameEnd(String gameEndInput) {
        return GameEndStatus.END.getValue().equals(gameEndInput);
    }

    public static boolean isValid(String value) {
        return Arrays.stream(values())
                .anyMatch(v -> v.getValue().equals(value));
    }
}
