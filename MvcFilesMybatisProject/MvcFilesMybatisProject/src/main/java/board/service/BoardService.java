package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dao.BoardDaoInter;
import spring.dto.ReBoardDto;

// dao�� �����ϰ� dbó���� �ϱ����� service������ logicó��

@Service
public class BoardService implements BoardServiceInter {

	// dao �������̽��� ������ Ŭ������ �ڵ�����
	// ��, �������̽��� ������ Ŭ������ �������ϰ�� ������ �߻��� �� �ִ�.
	// �̶� @Autowired�� �ƴ� @Resource�� ��Ȯ�� bean�� �̸��� ������ش�
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
		// ���۰� ��ۿ��� �޶����°� regroup, restep, relevel
		// �������� ������� �Ǵ��� num���� �Ѵ�
		
		String num = dto.getNum();
		int regroup = dto.getRegroup();
		int restep = dto.getRestep();
		int relevel = dto.getRelevel();
		
		if(num.equals("0")) { // ����
			regroup = getNumMax() + 1;
			restep = 0;
			relevel = 0;
		}
		else { // ���
			// ����ϰ�� ���� �׷��� ���޹��� restep���� ū ���� ��� 1�� �����ؼ� �ڷ� �и��� �Ѵ�.
			this.updateRestep(regroup, restep);
			// �׸��� ���޹��� step, level�� ��� 1�����ؼ� db�� ����
			restep += 1;
			relevel += 1;
		}
		// dto�� ����� ������ �ٽ� �����Ѵ�.
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		// db�� insert
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
