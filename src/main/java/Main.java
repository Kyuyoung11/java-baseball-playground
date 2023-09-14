import enums.GameEndStatus;
import services.BallsCreator;
import dto.Balls;
import utils.InputView;
import utils.ResultChecker;
import utils.ValidationUtils;

public class Main {
    private final static BallsCreator ballsCreator = new BallsCreator();
    private static final int SIZE = 3;
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        //1.난수 Balls 생성
        Balls randomBalls = ballsCreator.makeRandomBalls(SIZE);

        Balls userBalls = new Balls();
        do {
            //2. 사용자 Balls 입력
            userBalls = ballsCreator.getUserBalls();
        } while(!ResultChecker.compareAnswer(randomBalls, userBalls)); //3. 정답 비교


        //4. 재시작
        _checkRestartGame();
    }



    private static void _checkRestartGame() {
        String gameEnd = "";
        try {
            gameEnd = InputView.getGameEndNum();
            ValidationUtils.validateGameEnd(gameEnd);
        } catch(Exception e) {
            System.out.println("오류 메시지 : " + e);
        }

        if (GameEndStatus.isGameEnd(gameEnd))
            return;

        if (GameEndStatus.RESTART.getValue().equals(gameEnd))
            startGame();
    }
}
