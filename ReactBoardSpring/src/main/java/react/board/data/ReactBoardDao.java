package react.board.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ReactBoardDao extends SqlSessionDaoSupport implements ReactBoardDaoInter {

	@Override
	public List<ReactBoardDto> getList() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectAllOfBoard");
	}

	@Override
	public void insertBoard(ReactBoardDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfBoard", dto);
	}

	@Override
	public ReactBoardDto getData(String num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectOneOfBoard", num);
	}

	@Override
	public void updateReadCount(String num) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateReadCount", num);
	}

	@Override
	public void updateBoard(ReactBoardDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateOfBoard", dto);
	}

	@Override
	public void deleteBoard(String num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfBoard", num);
	}

	
}
