package boot.spring.dao;

import boot.spring.po.Staff;
import org.springframework.stereotype.Component;


@Component(value = "loginMapper")
public interface LoginDao {
	Staff getpwdbyname(String name);
	int regist(Staff staff);
}
