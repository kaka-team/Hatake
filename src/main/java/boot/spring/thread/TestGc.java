package boot.spring.thread;

import boot.spring.spring.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-12-30 14:22
 **/
public class TestGc {
    public static void main(String[] args) throws InterruptedException {
        List<User> ls = new ArrayList<>();
        while (true){
            User user = new User();
            ls.add(user);
        }
    }
}
