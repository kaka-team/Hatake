package boot.spring.listener;

import boot.spring.kafka.KafkaConsumer;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 系统初始化的监听器
 * @author Administrator
 *
 */
public class InitListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sc);
		SpringContext.setApplicationContext(context);
		System.out.println("------------开始监听");
		new Thread(new KafkaConsumer("test12321")).start();
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
