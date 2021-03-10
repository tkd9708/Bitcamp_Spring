package test2;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // ������ ������ ���Ǵ� Ŭ������� �˷��ִ� ������̼�
public class ApplicationConfig {

	@Bean // bean ��ü ����
	public Student student1() { // method �̸��� bean id�� �ȴ�.
		ArrayList<String> hobby = new ArrayList<String>();
		hobby.add("������ ����");
		hobby.add("�ڹ� ����");
		hobby.add("����Ʈ ����");
		
		Student s1 = new Student("������", 23, hobby);
		s1.setHeight(165.8);
		s1.setWeight(57.9);
		
		return s1;
	}
}
