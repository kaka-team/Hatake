package boot.spring.service;

import boot.spring.po.Person;

import java.util.List;

public interface PersonService {
    List<Person> selectAll();
    int insert(Person person);
    void update(Person person);
    void delete(long actor_id);
}
