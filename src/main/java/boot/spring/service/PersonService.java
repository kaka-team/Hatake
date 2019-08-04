package boot.spring.service;

import boot.spring.po.Person;

import java.util.List;

public interface PersonService {
    List<Person> selectAll();

}
