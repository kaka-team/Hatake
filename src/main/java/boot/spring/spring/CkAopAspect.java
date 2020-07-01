package boot.spring.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-06-28 17:04
 **/
@Aspect
@Component
public class CkAopAspect {
    // 配置织入点
    @Pointcut("@annotation(boot.spring.spring.TestCk)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("----------before---------");
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("----------after---------");
    }

}
