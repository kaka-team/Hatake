package boot.spring.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-06-30 11:24
 **/
@Service
public class UserService {
    @Autowired
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void test(){
        System.out.println(user.getClass());
    }
}
