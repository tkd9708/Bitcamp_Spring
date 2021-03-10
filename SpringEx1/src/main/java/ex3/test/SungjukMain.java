package ex3.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SungjukMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("config/appContext2.xml");
		Sungjuk s1 = context.getBean("sungjuk", Sungjuk.class);
		
		s1.studentInfo();
	}

}
