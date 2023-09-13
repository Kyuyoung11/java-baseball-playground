package utils;

import dto.Balls;
import enums.BallStatus;

import java.util.*;
import java.util.stream.Collectors;

public final class ResultChecker {

    public static boolean compareAnswer(Balls answerBalls, Balls tryBalls) {
        //1. 볼 비교 후 볼상태 가져옴
        List<BallStatus> ballStatusList = getEachBallStatus(answerBalls, tryBalls);

        //2. 결과 출력
        printResult(ballStatusList);

        //3. 정답인지 체크
        return isAnswer(ballStatusList);

    }

    /**
     * 볼 비교 후 볼상태 가져옴
     */
    public static List<BallStatus> getEachBallStatus(Balls answerBalls, Balls tryBalls) {
        return tryBalls.getBalls().stream()
                .map(answerBalls::getBallStatus)
                .collect(Collectors.toList());
    }

    /**
     * 결과 출력
     */
    public static void printResult(List<BallStatus> ballStatusList) {
        int nothingCnt = Collections.frequency(ballStatusList, BallStatus.NOTHING);
        if (nothingCnt == 3) {
            System.out.println("낫싱");
            return;
        }

        int ballCnt = Collections.frequency(ballStatusList, BallStatus.BALL);
        if (ballCnt > 0) {
            System.out.print(ballCnt + "볼 ");
        }

        int strikeCnt = Collections.frequency(ballStatusList, BallStatus.STRIKE);
        if (strikeCnt > 0) {
            System.out.print(strikeCnt + "스트라이크");
        }
        System.out.println();
    }

    /**
     * 정답인지 체크
     */
    public static boolean isAnswer(List<BallStatus> ballStatusList) {
        return Collections.frequency(ballStatusList, BallStatus.STRIKE) == 3;
    }


}
