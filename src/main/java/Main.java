
import java.util.LinkedHashSet;

public class Main {
    private static InputView inputView;
    private static BallsGenerator ballsGenerator;
    private static final int SIZE = 3;
    public static void main(String[] args) {
        gameStart();
    }

    public static void gameStart() {
        //1.난수생성
        Balls randomBalls = ballsGenerator.makeRandomBalls(SIZE);

        //2. 사용자 숫자 입력
        String numString = inputView.getNumberInput();
        Balls userBalls = ballsGenerator.convertFromStringToBalls(numString);

        //3. 정답과 비교


    }
}
