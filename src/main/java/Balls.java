import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class Balls {
    private List<Ball> balls;

    public Balls() {
        balls = new ArrayList<>();
    }

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public void addBall(Integer ballNumber) {
        if(!isBall(ballNumber)) {
            Ball newBall = new Ball(this.balls.size()+1, ballNumber);
            this.balls.add(newBall);
        }
    }

    public boolean isBall(Integer ballNumber) {
        return this.balls.stream()
                .anyMatch(ball -> ball.getNumber() == ballNumber);
    }

    public boolean isStrike(Ball ball) {
        return this.balls.get(ball.getPosition()-1).getNumber() == ball.getNumber();
    }

    public BallStatus getBallStatus(Ball ball) {
        if (isStrike(ball)) {
            return BallStatus.STRIKE;
        }
        if (isBall(ball.getNumber())) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;

    }
}
