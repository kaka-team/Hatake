package boot.spring.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-06-28 17:02
 **/
@Service()
public class AopTest {

    @TestCk
    public void test(){
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
       /* UserService t = (UserService) context.getBean("userService");
        t.test();*/
        System.out.println(context.getBean("user"));
    }
}
