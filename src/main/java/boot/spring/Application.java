package boot.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
@MapperScan("boot.spring.dao")
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public JedisCluster JedisClusterFactory() {
		final Logger LOG = LoggerFactory.getLogger(JedisCluster.class);

		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		jedisClusterNodes.add(new HostAndPort("47.99.108.50", 7000));
		jedisClusterNodes.add(new HostAndPort("47.99.108.50", 7001));
		jedisClusterNodes.add(new HostAndPort("47.99.108.50", 7002));
		jedisClusterNodes.add(new HostAndPort("47.99.108.50", 7003));
		jedisClusterNodes.add(new HostAndPort("47.99.108.50", 7004));
		jedisClusterNodes.add(new HostAndPort("47.99.108.50", 7005));
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(300);
		poolConfig.setMaxIdle(10);
		poolConfig.setMaxWaitMillis(1000);
		JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes, 50000, 50000, 5, "ck123" ,poolConfig);

		for (HostAndPort h :jedisClusterNodes) {
			LOG.info("redis->connect success :"+ h.toString());
		}
		return jedisCluster;

	}
}
