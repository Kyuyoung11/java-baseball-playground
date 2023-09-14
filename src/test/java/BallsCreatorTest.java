import services.BallsCreator;
import dto.Balls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallsCreatorTest {

    private BallsCreator ballsGenerator;

    @BeforeEach
    void setUp() {
        ballsGenerator = new BallsCreator();
    }

    @Test
    void makeRandomBallsTest() {
        Balls balls = ballsGenerator.makeRandomBalls(3);
        assertEquals(balls.getBalls().size(),3);
    }

    @Test
    void convertFromStringToBallsTest() {
        Balls balls = ballsGenerator.convertFromStringToBalls("123");
        assertEquals(balls.getBalls().get(0).getPosition(),1);
        assertEquals(balls.getBalls().get(0).getNumber(),1);

    }
}
