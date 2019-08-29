package boot.spring.controller;

import boot.spring.pagemodel.ActorGrid;
import boot.spring.po.Actor;
import boot.spring.service.ActorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.JedisCluster;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


@Api(tags = "演员接口")
@Controller
public class ActorController {
	@Autowired
	private ActorService actorservice;
	/*@Autowired
	JedisCluster jedis;*/
	private static final Logger LOG = LoggerFactory.getLogger(ActorController.class);

	public static void main(String[] args) {
		String a = new String("a");
		String b = "a";
		System.out.println (a == b);
	}
	@ApiOperation("获取所有演员列表")
	@RequestMapping(value="/actors",method = RequestMethod.GET)
	@ResponseBody
	public ActorGrid getactorlist(@RequestParam(value="current") int current,@RequestParam(value="rowCount") int rowCount){
		int total=actorservice.getactornum();
		List<Actor> list=actorservice.getpageActors(current,rowCount);
		//vo
		ActorGrid grid=new ActorGrid();
		grid.setCurrent(current);
		grid.setRowCount(rowCount);
		grid.setRows(list);
		grid.setTotal(total);
		//LOG.debug(jedisCluster.get("caokun"));
		LOG.debug("获取所有演员列表");
		return grid;
	}
	
	@ApiOperation("修改一个演员")
	@RequestMapping(value="/actors",method = RequestMethod.PUT)
	@ResponseBody
	public Actor updateactor(@RequestBody Actor a){
		//两个人都要进行图书的剩余量减一操作，此时剩余量只有1了
		//SETNX能保证，此时只有一个人能执行SETNX后面的代码
		//Long result = jedis.setnx("lock",System.currentTimeMillis ()+"");//LRU算法，要等好久才会过期，如果我们在拿到锁之后到
		//DEL锁这之间，代码出了问题，一直卡这里不动了，例如死循环，WHILE(TRUE)，意味着代码一直执行不到DEL这行，那怎么半？？
		//难道别人永远拿不到锁了？？
		//所以这个时候，我们一定要给这个锁设置一个最长时间，如果超过了这个时间，你还没释放锁，人家就自动给你释放了，也就是制动执行DEL这个方法了
		//jedis.expire ("lock",1);
		/*if(result == 0){
			//说明此时有别人拿到这个锁了，你给我排队等着
			//或者直接RETURN个NULL回去，告诉用户，设置失败，一会请重试
			return null;
		}*/
		//如果这里返回的是1，那么说明你这个时候成功拿到锁了，可以去进行扣减库存的操作了
		//然后这个时候第一件事情就是去查一下库存，是不是还剩下大于0的剩余量，如果大于0，那么就执行UPDATE操作，进行剩余量的扣减
		//否则，直接返回个NULL
		a.setLast_update(new Date());
		Actor actor=actorservice.updateactor(a);
		LOG.debug("修改一个演员");
		//执行完了以后，切记把这个锁给释放了，要不然别人就一直等不到了，你一直拿着这个锁
		//jedis.del ("lock");
		return actor;
	}
	
	@ApiOperation("获取一个演员")
	@RequestMapping(value="/actors/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Actor getactorbyid(@PathVariable("id") short id){
		Actor a=actorservice.getActorByid(id);
		LOG.debug("获取一个演员");
		return a;
	}
	
	@ApiOperation("添加一个演员")
	@RequestMapping(value="/actors",method = RequestMethod.POST)
	@ResponseBody
	public Actor add(@RequestBody Actor a){
		a.setLast_update(new Date());
		Actor actor=actorservice.addactor(a);
		LOG.debug("添加一个演员");
		return actor;
	}
	
	@ApiOperation("删除一个演员")
	@RequestMapping(value="/actors/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable("id") String id){
		actorservice.delete(Short.valueOf(id));
		LOG.debug("删除一个演员");
		return "success";
	}
	
	@ApiOperation("把演员导出为Excel")
	@RequestMapping(value="/exportactor",method = RequestMethod.GET)
	public void export(HttpServletResponse response) throws Exception{
		InputStream is=actorservice.getInputStream();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("contentDisposition", "attachment;filename=AllUsers.xls");
		ServletOutputStream output = response.getOutputStream();
		IOUtils.copy(is, output);
	}
	
	@RequestMapping(value="/showactor",method = RequestMethod.GET)
	String showactor(){
		return "showactor";
	}
}
