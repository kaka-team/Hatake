package boot.spring.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-06-30 11:54
 **/
public class CkBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if("user".equals(beanName)){
            User user = new User();
            user.setName("12321312321");
            return user;
        }
        return null;
    }
}
