package ex2.test;

public class Sawon {
	String name, hp, addr;
	
	// �̸��� �����ڸ� ���ؼ� ���Թް� ������ �ΰ��� setter�� ���ؼ� ���� (injection) �غ���
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
		System.out.println("�̸�: " + name);
		System.out.println("�ڵ���: " + hp);
		System.out.println("�ּ�: " + addr);
	}
}
