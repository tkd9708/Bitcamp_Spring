package test3;

import org.springframework.stereotype.Component;

//@Component : 자동으로 설정파일에 Bean 등록해주는 annotation
//@Component //  생략할 경우, 클래명이 아이디가 된다 (단 첫글자는 소문자 : myDao가 id가 된다)
@Component("dao")   // 설정해주면, dao가 id가된다.
public class MyDao implements DaoInter {

	@Override
	public void insertData(String str) {
		// TODO Auto-generated method stub

		System.out.println(str + " 데이터 DB에 추가완료!!");
	}

	@Override
	public void deleteData(String num) {
		// TODO Auto-generated method stub

		System.out.println(num + " 번호에 대한 데이터 삭제 완료!!");
	}

}
