package ex1.test;

public class Hello {
	String name;
	int age;
	
	public Hello() {
		// TODO Auto-generated constructor stub
		this.name = "홍길동";
		this.age = 21;
	}
	
	public String getMessage() {
		return "내이름은 " + name + "이고 " + age + "세 입니다.";
	}
}
