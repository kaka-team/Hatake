package boot.spring.test;

import kafka.serializer.StringEncoder;
import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * @Description TODO
 * @Author Simida
 **/
public class MsgProducer {

    public static void main(String[] args){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "47.99.108.50:19093,47.99.108.50:19094,47.99.108.50:19095");// 声明kafka broker
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = null;
        try {
            producer = new KafkaProducer<String, String>(properties);
            for (int i = 0; i < 100; i++) {
                String msg = "Message " + i;
                producer.send(new ProducerRecord<String, String>("test12321", msg));
                System.out.println("Sent:" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            producer.close();
        }

    }

}
