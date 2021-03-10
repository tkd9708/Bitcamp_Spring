package react.board.data;

import java.util.List;

public interface ReactBoardDaoInter {
	public List<ReactBoardDto> getList();
	public void insertBoard(ReactBoardDto dto);
	public ReactBoardDto getData(String num);
	public void updateReadCount(String num);
	public void updateBoard(ReactBoardDto dto);
	public void deleteBoard(String num);
}
