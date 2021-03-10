package ex2.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SawonMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		Sawon s1 = context.getBean("sawon", Sawon.class);
		s1.show();
		
		// EmpPay 생성후 write 호출
		EmpPay e1 = context.getBean("emp", EmpPay.class);
		e1.write();
	}
}
