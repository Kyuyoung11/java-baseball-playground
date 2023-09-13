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
        String gameEnd = InputView.getGameEndNum();

        if ("1".equals(gameEnd))
            startGame();
        else if ("2".equals(gameEnd))
            return;
    }
}
