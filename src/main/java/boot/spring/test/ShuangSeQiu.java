package boot.spring.test;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-06-08 10:47
 **/
public class ShuangSeQiu {
        public static void main(String[] args) {
            Random r = new Random();
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i < 34; i++) {
                set.add(i);
            }
            LinkedList<Integer> list = new LinkedList<>();
            list.addAll(set);
            Collections.shuffle(list);
            set.clear();
            for (int i = 0; i < 6; i++) {
                set.add(list.get(i));
            }
            System.out.print(""+set+"");
            int i = r.nextInt(16) + 1;
            System.out.println("["+i+"]");
        }

}
