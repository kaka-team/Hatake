package boot.spring.spring;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-06-30 11:24
 **/
@Component
public class User implements BeanNameAware {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println(s);
    }
}
