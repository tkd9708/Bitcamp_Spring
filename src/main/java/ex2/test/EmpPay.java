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
		System.out.println("** 사원에 대한 정보 **");
		sawon.show();
		System.out.println("** 이번달 급여 **");
		System.out.println(pay);
	}
}
