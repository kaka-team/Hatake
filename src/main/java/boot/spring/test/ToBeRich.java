package boot.spring.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Description TODO
 * @Author Simida
 **/
public class ToBeRich {

    public static void main(String[] args) {

        int[] ball = new int[7];
        for (int i = 0; i < ball.length - 2; i++) {
            int redBall = (int) (Math.random() * 35 + 1);
            ball[i] = redBall;
            for (int j = 0; j < i; j++) {
                if (ball[j] == ball[i]) {
                    i--;
                }
            }
        }
        for (int i = 5; i < ball.length; i++) {
            int blueBall = (int) (Math.random() * 12 + 1);
            ball[i] = blueBall;
            for (int j = 0; j < i; j++) {
                if (ball[j] == ball[i]) {
                    i--;
                    break;
                }
            }
        }
        for (int i : ball) {
            System.out.println(i);
        }
    }

}
