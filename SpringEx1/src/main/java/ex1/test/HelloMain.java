package ex1.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ���� �ڹ� ������� Hello ������ �޼��� ȣ��
		Hello h1 = new Hello();
		System.out.println(h1.getMessage());
		
		// ������������� Hello ������ �޼��� ȣ��
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		//Hello h2 = (Hello)context.getBean("hello"); // ��� 1
		Hello h2 = context.getBean("hello", Hello.class); // ��� 2
		Hello hh2 = context.getBean("hello", Hello.class);
		
		// singleton�� ��� �������� �����ص� �ּҰ� ����.
		// prototype�� ��� �����ø��� �ּҰ� �ٸ� ���� ������ �ȴ�.
		System.out.println(h2.hashCode());
		System.out.println(hh2.hashCode());
		
		System.out.println(h2.getMessage());
	}

}
