package test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {

	public static void write(Student s) {
		System.out.println("** ������ ��� **");
		System.out.println("�̸� : " + s.getName());
		System.out.println("��� : " + s.getHobby());
		System.out.println("Ű, ������ : " + s.getHeight() + ", " + s.getWeight());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("appContext1.xml");
		
		// �ڹ�Ŭ�������� ������ bean�� ������ ���Խ� �޼������ id�� �ȴ�.
		Student s1 = (Student)context.getBean("student1");
		write(s1);
		
		// ������ �ϴ� xml������� ������ ������ ���
		Student s2 = context.getBean("student2", Student.class);
		write(s2);
	}

}
