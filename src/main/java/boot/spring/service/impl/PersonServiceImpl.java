package boot.spring.service.impl;

import boot.spring.dao.PersonDao;
import boot.spring.po.Person;
import boot.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: Simida
 * @create: 2019-08-04 12:10
 **/
@Service("personService")
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;


    @Override
    public List<Person> selectAll() {
        return personDao.selectAll ();
    }

    @Override
    public int insert(Person person) {
        return personDao.insert (person);
    }

    @Override
    public void update(Person person) {
         personDao.update (person);
    }

    @Override
    public void delete(long actor_id) {
         personDao.delete (actor_id);
    }
}

