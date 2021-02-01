package data.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.setting.ConnectionManager;

public class CarMemberDao {
	ConnectionManager manager = ConnectionManager.getInstance();
	SqlSession session;
	
	private SqlSession getSession() {
		session = manager.openSession();
		
		return session;
	}
	
	public int getTotalCount() {
		int total = 0;
		session = this.getSession();
		total = session.selectOne("member.getTotalCountOfMember");
		session.close();
		
		return total;
	}
	
	public void insertMember(CarMemberDto dto) {
		session = this.getSession();
		session.insert("member.insertCarMember", dto);
		session.close();
	}
	
	public List<CarMemberDto> getAllMember(){
		List<CarMemberDto> list = null;
		session = this.getSession();
		list = session.selectList("member.getAllMember");
		session.close();
		return list;
	}
	
	public CarMemberDto getMember(String num){
		CarMemberDto dto = new CarMemberDto();
		session = this.getSession();
		dto = session.selectOne("member.getMember", num);
		session.close();
		return dto;
	}
	
	public void updateMember(CarMemberDto dto) {
		session = this.getSession();
		session.update("member.updateMember", dto);
		session.close();
	}
	
	public void deleteMember(String num) {
		session = this.getSession();
		session.delete("member.deleteMember", num);
		session.close();
	}
}
