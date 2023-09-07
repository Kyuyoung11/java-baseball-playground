public class BallClassifier {

    public boolean isStrike(Balls answerBalls, Ball tryBall) {
        return answerBalls.getBalls().get(tryBall.getPosition()-1).getNumber() == tryBall.getNumber();
    }

    public boolean isBall(Balls answerBalls, Ball tryBall) {
        return answerBalls.isDuplicateBall(tryBall.getNumber());
    }

    public BallStatus classifyBallStatus(Balls answerBalls, Ball tryBall) {
        System.out.println(tryBall.getPosition()+", "+tryBall.getNumber());
        if (isStrike(answerBalls, tryBall)) {
            return BallStatus.STRIKE;
        }
        if (isBall(answerBalls, tryBall)) {
            return BallStatus.BALL;
        }
        return null;
    }
}
