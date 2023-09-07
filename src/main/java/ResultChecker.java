import java.util.HashMap;
import java.util.Map;

public class ResultChecker {

    public boolean compareAnswer(Balls answerBalls, Balls tryBalls) {
        Map<BallStatus, Integer> counter = new HashMap<>();

        BallClassifier ballClassifier = new BallClassifier();
        for (Ball ball : tryBalls.getBalls()) {
            BallStatus ballStatus = ballClassifier.classifyBallStatus(answerBalls, ball);
            counter.put(ballStatus, counter.get(ballStatus)+1);
        }



        return counter.get(BallStatus.STRIKE) == 3;

    }
}
