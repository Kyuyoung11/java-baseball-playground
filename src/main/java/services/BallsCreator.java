package services;

import dto.Balls;
import utils.InputView;
import utils.ValidationUtils;

import java.util.Random;

public class BallsCreator {
    public Balls makeRandomBalls(int size) {
        Balls balls = new Balls();
        Random rd = new Random();
        while(balls.getBalls().size() < size) {
            balls.addUniqueBall(rd.nextInt(9)+1);
        }
        return balls;
    }

    public Balls convertFromStringToBalls(String numString) {
        String[] nums = numString.split("");
        Balls balls = new Balls();
        for (String num : nums) {
            balls.addUniqueBall(Integer.parseInt(num));
        }
        return balls;
    }

    public Balls getUserBalls() {
        Balls userBalls = new Balls();
        try {
            //2-1. 사용자 입력 받기
            String numString = InputView.getNumberInput();

            //2-2. String To Balls 변환
            userBalls = convertFromStringToBalls(numString);

            //2-3. 사용자 입력 숫자 검증
            ValidationUtils.validateBalls(userBalls);

        } catch(Exception e) {
            System.out.println("오류 : " + e.getMessage());
        }
        return userBalls;
    }
}
