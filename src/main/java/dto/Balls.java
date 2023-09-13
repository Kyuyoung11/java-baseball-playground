package dto;

import enums.BallStatus;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Balls {
    private List<Ball> balls;

    public Balls() {
        balls = new ArrayList<>();
    }

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public void addUniqueBall(Integer ballNumber) {
        if(!isUniqueBall(ballNumber)) {
            Ball newBall = new Ball(this.balls.size()+1, ballNumber);
            this.balls.add(newBall);
        }
    }

    public boolean isUniqueBall(Integer ballNumber) {
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
        if (isUniqueBall(ball.getNumber())) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;

    }

    public int getSize() {
        return this.balls.size();
    }
}
