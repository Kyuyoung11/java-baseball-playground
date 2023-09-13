package utils;

import java.util.Scanner;

public final class InputView {
    public static Scanner sc =  new Scanner(System.in);

    public static String getNumberInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        return sc.nextLine();
    }

    public static String getGameEndNum() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return sc.nextLine();
    }
}
