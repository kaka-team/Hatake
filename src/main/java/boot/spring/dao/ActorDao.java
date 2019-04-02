package boot.spring.dao;

import java.util.List;

import boot.spring.po.Actor;
import org.springframework.stereotype.Component;

//mybatis的实体类和hibernate实体类的不同是mybatis的实体类不需要加载到spring的beanFactory中，
//而是通过操作数据库的mapper来持久化数据,相当于DAO层。
@Component(value = "actorMapper")
public interface ActorDao {
	public List<Actor> getAllactors();
	public void updateActorbyid(Actor a);
	public Actor getactorbyid(short id);
	public int insertActor(Actor a);
	public void delete(short id);
}
