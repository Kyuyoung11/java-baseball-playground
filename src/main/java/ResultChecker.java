import java.util.*;
import java.util.stream.Collectors;

public class ResultChecker {

    public boolean compareAnswer(Balls answerBalls, Balls tryBalls) {
        List<BallStatus> ballStatusList = countBalls(answerBalls, tryBalls);

        printResult(ballStatusList);

        return isAnswer(ballStatusList);

    }

    private void printResult(List<BallStatus> ballStatusList) {
        if (Collections.frequency(ballStatusList, BallStatus.NOTHING) == 3) {
            System.out.println("낫싱");
            return;
        }

        if (Collections.frequency(ballStatusList, BallStatus.BALL) > 0) {
            System.out.print(Collections.frequency(ballStatusList, BallStatus.BALL) + "볼 ");
        }
        if (Collections.frequency(ballStatusList, BallStatus.STRIKE) > 0) {
            System.out.print(Collections.frequency(ballStatusList, BallStatus.STRIKE) + "스트라이크");
        }
        System.out.println();
    }

    private boolean isAnswer(List<BallStatus> ballStatusList) {
        return Collections.frequency(ballStatusList, BallStatus.STRIKE) == 3;
    }

    public List<BallStatus> countBalls(Balls answerBalls, Balls tryBalls) {
        return tryBalls.getBalls().stream()
                .map(answerBalls::getBallStatus)
                .collect(Collectors.toList());
    }
}
