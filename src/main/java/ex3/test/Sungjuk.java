package ex3.test;

public class Sungjuk {
	Student stu;
	String schoolName;
	
	public Sungjuk(Student stu) {
		super();
		this.stu = stu;
	}
	
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public void studentInfo() {
		System.out.println("�б��� : " + schoolName);
		System.out.println("�л��� : " + stu.getName());
		System.out.println("�������� : " + stu.getKor());
		System.out.println("�������� : " + stu.getEng());
		System.out.println("�������� : " + stu.getMat());
		System.out.println("���� : " + (stu.getKor()+stu.getEng()+stu.getMat()));
	}
}
