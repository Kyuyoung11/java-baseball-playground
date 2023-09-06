public class ResultChecker {

    public boolean compareAnswer(Balls answerBalls, Balls tryBalls) {

        BallClassifier ballClassifier = new BallClassifier();
        long ballCnt = tryBalls.getBalls().stream()
                 .filter(tryBall -> ballClassifier.isBall(answerBalls, tryBall))
                 .count();
        long strikeCnt = tryBalls.getBalls().stream()
                .filter(tryBall -> ballClassifier.isBall(answerBalls, tryBall))
                .count();

        return strikeCnt == 3;



    }
}
