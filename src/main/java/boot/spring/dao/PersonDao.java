package boot.spring.dao;

import boot.spring.po.Person;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("personDao")
public interface PersonDao {
    List<Person> selectAll();
    List<Person> selectByParam();
    /**
     * 增加功能元素
     * @param person
     * @return
     */
    int insert(Person person);
    void update(Person person);
    void delete(long actor_id);
}
