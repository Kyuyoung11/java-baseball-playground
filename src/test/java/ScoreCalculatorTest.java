import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ScoreCalculatorTest {
    ScoreCalculator scoreCalculator = null;

    private Balls _makeTestBalls() {
        List<Ball> testBalls = new ArrayList<>();
        testBalls.add(new Ball(1,2));
        testBalls.add(new Ball(2,3));
        testBalls.add(new Ball(3,4));
        return new Balls(testBalls);
    }
    @BeforeEach
    void setUp() {
        scoreCalculator = new ScoreCalculator();
    }

    @Test
    void scoreTest() {
        Balls balls = _makeTestBalls();
        scoreCalculator.printResult(balls, balls);
    }
}
