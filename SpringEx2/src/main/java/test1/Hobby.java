package test1;

import java.util.ArrayList;
import java.util.List;

public class Hobby {
	String name;
	List<String> list = new ArrayList<String>();
	
	public Hobby(String name, List<String> list) {
		super();
		this.name = name;
		this.list = list;
	}
	
	public void write() {
		System.out.println("�̸� : " + name);
		System.out.println("** ���� ��̵� **");
		
		/*
		 * for(String h : list) { System.out.println(h); }
		 */
		
		// ���ٽ����� ���
		list .forEach(h->System.out.println(h));
	}
}
