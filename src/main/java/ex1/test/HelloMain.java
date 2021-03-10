package ex1.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 기존 자바 방식으로 Hello 생성후 메서드 호출
		Hello h1 = new Hello();
		System.out.println(h1.getMessage());
		
		// 스프링방식으로 Hello 생성후 메서드 호출
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		//Hello h2 = (Hello)context.getBean("hello"); // 방법 1
		Hello h2 = context.getBean("hello", Hello.class); // 방법 2
		Hello hh2 = context.getBean("hello", Hello.class);
		
		// singleton일 경우 여러개를 생성해도 주소가 같다.
		// prototype일 경우 생성시마다 주소가 다른 곳에 생성이 된다.
		System.out.println(h2.hashCode());
		System.out.println(hh2.hashCode());
		
		System.out.println(h2.getMessage());
	}

}
