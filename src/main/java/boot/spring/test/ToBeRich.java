package boot.spring.test;

import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Description money
 * @Author Hatake
 **/
public class ToBeRich {

    public static void main(String[] args) {
        cal();
    }
    public static void cal(){
        List<Integer> red = new ArrayList<>();
        List<Integer> blue = new ArrayList<>();
        while (red.size() < 5) {
            int a = (int) (Math.random() * 35 + 1);
            if (!red.contains(a)) {
                red.add(a);
            }
        }
        while (blue.size() < 2) {
            int b = (int) (Math.random() * 12 + 1);
            if (!blue.contains(b)) {
                blue.add(b);
            }
        }
        Collections.sort(red);
        Collections.sort(blue);
        System.out.print(red);
        System.out.println(blue);
    }
}
