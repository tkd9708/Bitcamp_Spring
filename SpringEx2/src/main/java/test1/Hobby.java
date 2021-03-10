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
		System.out.println("이름 : " + name);
		System.out.println("** 나의 취미들 **");
		
		/*
		 * for(String h : list) { System.out.println(h); }
		 */
		
		// 람다식으로 출력
		list .forEach(h->System.out.println(h));
	}
}
