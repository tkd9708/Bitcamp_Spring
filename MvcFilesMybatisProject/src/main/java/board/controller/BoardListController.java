package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.dao.AnswerDao;
import board.service.BoardServiceInter;
import spring.dto.ReBoardDto;

@Controller
public class BoardListController {
	
	@Autowired
	private BoardServiceInter service;
	
	@Autowired
	private AnswerDao adao;
	
	@GetMapping("/board/list")
	public String goBoardList(
			@RequestParam(value="pageNum", defaultValue="1") int currentPage, Model model
			) {
		int totalCount = service.getTotalCount();
		int perPage = 5; // ���������� ������ ���� ����
		int perBlock = 5; // �Ѻ��� ����� �������� ����
		int totalPage; // �� �������� ����
		int startPage; // �� ���� ���� ������ ��ȣ
		int endPage; // �� ���� �������� ��ȣ
		int start; // �� ���� �ҷ��� ���� ���۹�ȣ
		
		totalPage = totalCount/perPage + (totalCount % perPage > 0 ? 1 : 0);
		startPage = (currentPage - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;
		if(endPage > totalPage)
			endPage = totalPage;

		// mysql�� ù ���� 0���̹Ƿ� +1 ���ص��� (����Ŭ�� 1��)
		start = (currentPage-1) * perPage;
		
		// �� ���������� ����� ���۹�ȣ
		// �� 50���ϰ�� 1�������� 50, 2�������� 40
		int no = totalCount-(currentPage - 1) * perPage;
		
		// db�κ��� ����� ��� ��������
		List<ReBoardDto> list = service.getList(start, perPage);
		
		if(list.size()==0) {
			return "redirect:list?pageNum="+(currentPage-1);
		}
		
		for(ReBoardDto dto:list) {
			dto.setCnt(adao.getAnswerList(dto.getNum()).size());
		}
		
		AnswerDao adao = new AnswerDao();
		// model�� ����
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("list", list);
		model.addAttribute("no", no);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("totalPage", totalPage);
		return "/sub/board/boardlist";
	}
	
}
