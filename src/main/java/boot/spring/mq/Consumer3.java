package boot.spring.mq;

import boot.spring.dao.ActorDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@Description TODO
 *@Author Simida
 **/

@Component
@RabbitListener(queues = RabbitConfig.QUEUE_B)
public class Consumer3 {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ActorDao actorDao;
    @RabbitHandler
    public void process(String content) {
        logger.info("three:接收处理队列B当中的消息： " + content);
    }

}
