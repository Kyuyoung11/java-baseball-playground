import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ResultCheckerTest {
    ResultChecker resultChecker = null;

    private Balls _makeTestBalls() {
        List<Ball> testBalls = new ArrayList<>();
        testBalls.add(new Ball(1,2));
        testBalls.add(new Ball(2,3));
        testBalls.add(new Ball(3,4));
        return new Balls(testBalls);
    }
    @BeforeEach
    void setUp() {
        resultChecker = new ResultChecker();
    }


}
