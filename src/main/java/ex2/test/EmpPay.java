package ex2.test;

public class EmpPay {
	Sawon sawon;
	int pay;
	
	public EmpPay(Sawon sawon) {
		// TODO Auto-generated constructor stub
		this.sawon = sawon;
	}
	
	public void setPay(int pay) {
		this.pay = pay;
	}
	
	public void write() {
		System.out.println("** ����� ���� ���� **");
		sawon.show();
		System.out.println("** �̹��� �޿� **");
		System.out.println(pay);
	}
}
