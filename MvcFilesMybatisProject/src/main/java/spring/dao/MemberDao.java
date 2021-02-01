package spring.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import spring.dto.MemberDto;

@Repository
public class MemberDao extends SqlSessionDaoSupport{
	public int idCheck(String myid) {
		// �̹� ���̵� �ִ� ��� 1 ��ȯ
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
		// map���� ��� �Ķ���ͷ� ������
		HashMap<String, String>map = new HashMap<String, String>();
		map.put("num", num);
		map.put("pass", pass);
		
		// ����� ������ 1, Ʋ���� 0 ��ȯ
		return getSqlSession().selectOne("passCheckOfMember", map);
	}
	
	public void updateMember(MemberDto dto) {
		getSqlSession().update("updateOfMember", dto);
	}
	
	public void deleteMember(String num) {
		getSqlSession().delete("deleteOfMember", num);
	}
}
