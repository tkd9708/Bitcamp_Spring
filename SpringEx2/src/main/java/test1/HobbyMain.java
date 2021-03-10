package test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HobbyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("appContext1.xml");
		Hobby h1 = (Hobby)context.getBean("hobby");
		h1.write();
	}

}
