package boot.spring.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *@Description TODO
 *@Author Simida
 **/

@Component
@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class Consumer2 {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(String content) {
        logger.info("two:接收处理队列A当中的消息： " + content);
    }

}
