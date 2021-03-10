package ex4.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataSourceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("config/rootcontext.xml");
		DataSource d1 = context.getBean("oraclesource", DataSource.class);
		d1.serverInfo();
	}

}
