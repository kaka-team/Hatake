package boot.spring.test;

import boot.spring.Application;
import boot.spring.dao.ActorDao;
import boot.spring.dao.LoginDao;
import boot.spring.mq.Producer;
import boot.spring.po.Actor;
import boot.spring.po.Staff;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ActorMapperTest {
    @Autowired
    private ActorDao actorMapper;
    @Autowired
    private LoginDao loginDao;
    @Autowired
    private Producer producer;
    @Test
    public void insertActor() {
        Actor actor = new Actor();
        actor.setFirst_name("cao");
        actor.setLast_name("kun");
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(new Date());
            actor.setLast_update(formatter.parse(dateString));
            int b = actorMapper.insertActor(actor);
            int a = 1;
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Test
    public void zhuce(){
        Staff staff = new Staff();
        staff.setUsername("admin");
        staff.setPassword("123456");
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(new Date());
            staff.setLast_update(formatter.parse(dateString));
            int b = loginDao.regist(staff);
            int a = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testMybatis(){
        try{
            SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            //获取session对象
             SqlSession session = sf.openSession();
             ActorDao actorDao = session.getMapper(ActorDao.class);
             actorDao.getAllactors();
             session.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testMq(){
         producer.sendAll("广播1111");
    }


}