public class Main {
    private static InputView inputView = new InputView();
    private static BallsGenerator ballsGenerator = new BallsGenerator();
    private static ResultChecker resultChecker = new ResultChecker();
    private static final int SIZE = 3;
    public static void main(String[] args) {
        gameStart();
    }

    public static void gameStart() {
        //1.난수생성
        Balls randomBalls = ballsGenerator.makeRandomBalls(SIZE);

        Balls userBalls;
        do {
            //2. 사용자 숫자 입력
            String numString = inputView.getNumberInput();
            userBalls = ballsGenerator.convertFromStringToBalls(numString);
        } while(!resultChecker.compareAnswer(randomBalls, userBalls)); //3. 정답 비교


        //4. 재시작
        String gameEnd = inputView.getGameEndNum();
        if ("1".equals(gameEnd))
            gameStart();
        else if ("2".equals(gameEnd))
            return;
    }
}
