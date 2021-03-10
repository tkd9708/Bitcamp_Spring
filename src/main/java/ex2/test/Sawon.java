package ex2.test;

public class Sawon {
	String name, hp, addr;
	
	// 이름은 생성자를 통해서 주입받고 나머지 두개는 setter를 통해서 주입 (injection) 해보자
	public Sawon(String name) {
		// TODO Auto-generated constructor stub
		this.name = name; // injection
	}
	
	public void setHp(String hp) {
		this.hp = hp;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public void show() {
		System.out.println("이름: " + name);
		System.out.println("핸드폰: " + hp);
		System.out.println("주소: " + addr);
	}
}
