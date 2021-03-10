package spring.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import spring.dto.FoodDto;

@Repository
public class FoodDao extends SqlSessionDaoSupport{
	
	public void insert(FoodDto dto) {
		getSqlSession().insert("insertOfFood", dto);
	}
	
	public List<FoodDto> getAllDatas(){
		return getSqlSession().selectList("AllOfFood");
	}
}
