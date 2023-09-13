import dto.Ball;
import dto.Balls;
import enums.BallStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ResultChecker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void status3Strike() {
        Balls testBalls = _makeTestBalls();
        List<BallStatus> ballStatuses = resultChecker.getEachBallStatus(testBalls,testBalls);
        assertEquals(Collections.frequency(ballStatuses, BallStatus.STRIKE), 3);
    }

    @Test
    void isAnswerTestFalse() {
        List<BallStatus> ballStatuses = new ArrayList<>();
        ballStatuses.add(BallStatus.BALL);
        ballStatuses.add(BallStatus.STRIKE);
        ballStatuses.add(BallStatus.NOTHING);
        assertFalse(resultChecker.isAnswer(ballStatuses));
    }

    @Test
    void isAnswerTestTrue() {
        List<BallStatus> ballStatuses = new ArrayList<>();
        ballStatuses.add(BallStatus.STRIKE);
        ballStatuses.add(BallStatus.STRIKE);
        ballStatuses.add(BallStatus.STRIKE);
        assertTrue(resultChecker.isAnswer(ballStatuses));
    }


}
