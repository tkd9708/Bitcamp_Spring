package spring.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import spring.dto.MemberDto;

@Repository
public class MemberDao extends SqlSessionDaoSupport{
	public int idCheck(String myid) {
		// 이미 아이디가 있는 경우 1 반환
		return getSqlSession().selectOne("idCheckOfMember", myid);
	}
	
	public void insertMember(MemberDto dto) {
		
		getSqlSession().insert("insertOfMeber", dto);
	}
	
	public List<MemberDto> getAllDatas(){
		return getSqlSession().selectList("selectAllOfMember");
	}
	
	public MemberDto getData(String num) {
		return getSqlSession().selectOne("detailOfMember", num);
	}
	
	public int getPassIsCheck(String num, String pass) {
		// map으로 묶어서 파라미터로 보낸다
		HashMap<String, String>map = new HashMap<String, String>();
		map.put("num", num);
		map.put("pass", pass);
		
		// 비번이 맞으면 1, 틀리면 0 반환
		return getSqlSession().selectOne("passCheckOfMember", map);
	}
	
	public void updateMember(MemberDto dto) {
		getSqlSession().update("updateOfMember", dto);
	}
	
	public void deleteMember(String num) {
		getSqlSession().delete("deleteOfMember", num);
	}
}
