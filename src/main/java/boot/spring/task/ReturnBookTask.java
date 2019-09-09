package boot.spring.task;

import boot.spring.po.Actor;
import boot.spring.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2019-09-09 21:29
 **/
@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ReturnBookTask {
    @Autowired
    private ActorService actorService;

    private Integer time = 0;
    //3.添加定时任务
    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {

        //假设这是从数据库里查出y已经 距离还书不足24小时的同学
        time+=1;
       List<Actor> ls = actorService.getpageActors(1,10);
       System.err.println("执行定时任务时间: " + LocalDateTime.now()+":查出来的第一个人是"+ls.get(0).getFirst_name()+ls.get(0).getLast_name()+",从项目启动已经执行了第"+time+"次");
    }
}
