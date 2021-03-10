package test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {

	public static void write(Student s) {
		System.out.println("** 데이터 출력 **");
		System.out.println("이름 : " + s.getName());
		System.out.println("취미 : " + s.getHobby());
		System.out.println("키, 몸무게 : " + s.getHeight() + ", " + s.getWeight());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("appContext1.xml");
		
		// 자바클래스에서 설정후 bean에 데이터 주입시 메서드명이 id가 된다.
		Student s1 = (Student)context.getBean("student1");
		write(s1);
		
		// 기존에 하던 xml방식으로 데이터 주입후 출력
		Student s2 = context.getBean("student2", Student.class);
		write(s2);
	}

}
