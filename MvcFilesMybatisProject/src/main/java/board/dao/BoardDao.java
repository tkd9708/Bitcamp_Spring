package board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import spring.dto.ReBoardDto;

@Repository
public class BoardDao extends SqlSessionDaoSupport implements BoardDaoInter {

	@Override
	public int getNumMax() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("maxNumOfBoard");
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("totalCountOfBoard");
	}
	
	@Override
	public void updateRestep(int regroup, int restep) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("regroup", regroup);
		map.put("restep", restep);
		getSqlSession().update("updateRestepOfBoard", map);
	}

	@Override
	public int getCheckPass(String num, String pass) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("num", num);
		map.put("pass", pass);
		
		return getSqlSession().selectOne("passCheckOfBoard", map);
	}

	@Override
	public void updateReadCount(String num) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateOfReadcount", num);
	}

	@Override
	public void insertBoard(ReBoardDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfBoard", dto);
	}

	@Override
	public List<ReBoardDto> getList(int start, int perpage) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		return getSqlSession().selectList("selectAllOfBoard", map);
	}

	@Override
	public ReBoardDto getData(String num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectOfBoard", num);
	}

	@Override
	public void updateBoard(ReBoardDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateOfBoard", dto);
	}

	@Override
	public void deleteBoard(String num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfBoard", num);
	}

}
