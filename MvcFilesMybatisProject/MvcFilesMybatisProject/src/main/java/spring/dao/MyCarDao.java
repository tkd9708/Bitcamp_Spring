package spring.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import spring.dto.MyCarDto;

/*
	@Component : 어플리케이션에서 자동으로 xml에 bean을 등록
	=> webmvc에서는 3가지로 나눠진다. @Controller, @Repository, @Service >> 모두 기능은 같음(자동으로 bean등록)
	종류에 따라 나눠놓은 것음

*/

@Repository // rootcontext에서 bean id="carDao" 이부분 대신 하는 것
public class MyCarDao extends SqlSessionDaoSupport{
	
	// 전체 갯수 반환
	public int getTotalCount() {
		
		return getSqlSession().selectOne("car.totalCountOfCar");
	}
	
	// 전체 목록 반환
	public List<MyCarDto> getAllDatas(){
		
		return getSqlSession().selectList("car.selectAllOfCar");
	}
	
	// insert
	public void insertCar(MyCarDto dto) {
		
		getSqlSession().insert("insertOfCar", dto);
	}
	
	public MyCarDto getData(String num) {
		return getSqlSession().selectOne("selectOneOfCar", num);
	}
	
	public void updateCar(MyCarDto dto) {
		getSqlSession().update("updateOfCar", dto);
	}
	
	public void deleteCar(String num) {
		getSqlSession().delete("deleteOfCar", num);
	}
}
