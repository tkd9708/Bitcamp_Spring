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
		System.out.println("학교명 : " + schoolName);
		System.out.println("학생명 : " + stu.getName());
		System.out.println("국어점수 : " + stu.getKor());
		System.out.println("영어점수 : " + stu.getEng());
		System.out.println("수학점수 : " + stu.getMat());
		System.out.println("총점 : " + (stu.getKor()+stu.getEng()+stu.getMat()));
	}
}
