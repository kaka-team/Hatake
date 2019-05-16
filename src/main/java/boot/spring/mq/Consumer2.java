package boot.spring.mq;

import boot.spring.dao.ActorDao;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;


/**
 *@Description TODO
 *@Author Simida
 **/

@Component
@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class Consumer2 {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ActorDao actorDao;
    @RabbitHandler
    public void process(String message, Channel channel, @Headers Map<String,Object> map) {
        logger.info("two:接收处理队列A当中的消息： " + message);
        System.out.println(message);
        if (map.get("error")!= null){
            System.out.println("错误的消息");
            try {
                channel.basicNack((Long)map.get(AmqpHeaders.DELIVERY_TAG),false,true);      //否认消息
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            channel.basicAck((Long)map.get(AmqpHeaders.DELIVERY_TAG),false);            //确认消息
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
