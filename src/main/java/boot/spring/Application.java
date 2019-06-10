package boot.spring;

import boot.spring.listener.InitListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@MapperScan("boot.spring.dao")
@EnableScheduling
public class Application {
	/*@Bean
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

        }*/
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public ServletListenerRegistrationBean servletListenerRegistrationBean() {
		ServletListenerRegistrationBean servletListenerRegistrationBean =
				new ServletListenerRegistrationBean();
		servletListenerRegistrationBean.setListener(new InitListener());
		return servletListenerRegistrationBean;
	}
}
