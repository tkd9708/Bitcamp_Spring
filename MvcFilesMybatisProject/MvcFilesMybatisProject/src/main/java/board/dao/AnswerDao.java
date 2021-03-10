package board.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import spring.dto.ReAnswerDto;

@Repository
public class AnswerDao extends SqlSessionDaoSupport {
	
	public void insertAnswer(ReAnswerDto dto) {
		getSqlSession().insert("insertOfAnswer", dto);
	}
	
	public List<ReAnswerDto> getAnswerList(String num){
		return getSqlSession().selectList("selectAllOfAnswer", num);
	}
	
	public void deleteAnswer(String idx) {
		getSqlSession().delete("deleteOfAnswer", idx);
	}
	
	public ReAnswerDto getData(String idx) {
		return getSqlSession().selectOne("selectOfAnswer", idx);
	}
	
	public void updateAnswer(ReAnswerDto dto) {
		getSqlSession().update("updateOfAnswer", dto);
	}
}
