package board.dao;

import java.util.List;

import spring.dto.ReBoardDto;

public interface BoardDaoInter {

	public int getNumMax();
	public int getTotalCount();
	public void updateRestep(int regroup, int restep);
	public int getCheckPass(String num, String pass);
	public void updateReadCount(String num);
	public void insertBoard(ReBoardDto dto);
	public List<ReBoardDto> getList(int start, int perpage);
	public ReBoardDto getData(String num);
	public void updateBoard(ReBoardDto dto);
	public void deleteBoard(String num);
}
