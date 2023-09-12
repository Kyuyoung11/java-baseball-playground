import java.util.Random;

public class BallsGenerator {
    public Balls makeRandomBalls(int size) {
        Balls balls = new Balls();
        Random rd = new Random();
        while(balls.getBalls().size() < size) {
            balls.addBall(rd.nextInt(9)+1);
        }
        return balls;
    }

    public Balls convertFromStringToBalls(String numString) {
        String[] nums = numString.split("");
        Balls balls = new Balls();
        for (String num : nums) {
            balls.addBall(Integer.parseInt(num));
        }
        return balls;
    }
}
