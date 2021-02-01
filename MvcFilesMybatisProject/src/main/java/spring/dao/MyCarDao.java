package spring.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import spring.dto.MyCarDto;

/*
	@Component : ���ø����̼ǿ��� �ڵ����� xml�� bean�� ���
	=> webmvc������ 3������ ��������. @Controller, @Repository, @Service >> ��� ����� ����(�ڵ����� bean���)
	������ ���� �������� ����

*/

@Repository // rootcontext���� bean id="carDao" �̺κ� ��� �ϴ� ��
public class MyCarDao extends SqlSessionDaoSupport{
	
	// ��ü ���� ��ȯ
	public int getTotalCount() {
		
		return getSqlSession().selectOne("car.totalCountOfCar");
	}
	
	// ��ü ��� ��ȯ
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
