package boot.spring.dao;

import boot.spring.po.Person;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("personDao")
public interface PersonDao {
    List<Person> selectAll();

}
