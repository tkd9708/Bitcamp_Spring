package test3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3Main {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext2.xml");
		ListController listCont = (ListController)context.getBean("listController"); // @Component일 시
		//ListController listCont = (ListController)context.getBean("list"); // @Component("list")일 시
		listCont.process();
	}
}
