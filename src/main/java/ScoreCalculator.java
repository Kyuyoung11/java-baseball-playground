public class ScoreCalculator {

    public String printResult(Balls answerBalls, Balls tryBalls) {
        tryBalls.getBalls().stream()
                .filter(tryBall -> answerBalls.isDuplicateBall(tryBall.getNumber()))
                .count();
        return "";
    }
}
