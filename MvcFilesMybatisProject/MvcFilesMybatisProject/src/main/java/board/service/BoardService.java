package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dao.BoardDaoInter;
import spring.dto.ReBoardDto;

// dao는 간단하게 db처리만 하기위해 service에서는 logic처리

@Service
public class BoardService implements BoardServiceInter {

	// dao 인터페이스를 구현한 클래스가 자동주입
	// 단, 인터페이스를 구현한 클래스가 여러개일경우 오류가 발생할 수 있다.
	// 이때 @Autowired가 아닌 @Resource로 정확한 bean의 이름을 명시해준다
	@Autowired 
	private BoardDaoInter dao;
	
	@Override
	public int getNumMax() {
		// TODO Auto-generated method stub
		return dao.getNumMax();
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return dao.getTotalCount();
	}
	
	@Override
	public void updateRestep(int regroup, int restep) {
		// TODO Auto-generated method stub
		dao.updateRestep(regroup, restep);
	}

	@Override
	public int getCheckPass(String num, String pass) {
		// TODO Auto-generated method stub
		return dao.getCheckPass(num, pass);
	}

	@Override
	public void updateReadCount(String num) {
		// TODO Auto-generated method stub
		dao.updateReadCount(num);
	}

	@Override
	public void insertBoard(ReBoardDto dto) {
		// TODO Auto-generated method stub
		// 새글과 답글에서 달라지는건 regroup, restep, relevel
		// 새글인지 답글인지 판단은 num으로 한다
		
		String num = dto.getNum();
		int regroup = dto.getRegroup();
		int restep = dto.getRestep();
		int relevel = dto.getRelevel();
		
		if(num.equals("0")) { // 새글
			regroup = getNumMax() + 1;
			restep = 0;
			relevel = 0;
		}
		else { // 답글
			// 답글일경우 같은 그룹중 전달받은 restep보다 큰 값은 모두 1을 증가해서 뒤로 밀리게 한다.
			this.updateRestep(regroup, restep);
			// 그리고 전달받은 step, level을 모두 1증가해서 db에 저장
			restep += 1;
			relevel += 1;
		}
		// dto에 변경된 값들을 다시 저장한다.
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		// db에 insert
		dao.insertBoard(dto);
	}

	@Override
	public List<ReBoardDto> getList(int start, int perpage) {
		// TODO Auto-generated method stub
		return dao.getList(start, perpage);
	}

	@Override
	public ReBoardDto getData(String num) {
		// TODO Auto-generated method stub
		return dao.getData(num);
	}

	@Override
	public void updateBoard(ReBoardDto dto) {
		// TODO Auto-generated method stub
		dao.updateBoard(dto);
	}

	@Override
	public void deleteBoard(String num) {
		// TODO Auto-generated method stub
		dao.deleteBoard(num);
	}

}
