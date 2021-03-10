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
		int perPage = 5; // 한페이지당 보여질 글의 갯수
		int perBlock = 5; // 한블럭당 출력할 페이지의 갯수
		int totalPage; // 총 페이지의 갯수
		int startPage; // 각 블럭당 시작 페이지 번호
		int endPage; // 각 블럭당 끝페이지 번호
		int start; // 각 블럭당 불러올 글의 시작번호
		
		totalPage = totalCount/perPage + (totalCount % perPage > 0 ? 1 : 0);
		startPage = (currentPage - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;
		if(endPage > totalPage)
			endPage = totalPage;

		// mysql은 첫 글이 0번이므로 +1 안해도됨 (오라클은 1번)
		start = (currentPage-1) * perPage;
		
		// 각 페이지에서 출력할 시작번호
		// 총 50개일경우 1페이지는 50, 2페이지는 40
		int no = totalCount-(currentPage - 1) * perPage;
		
		// db로부터 출력할 목록 가져오기
		List<ReBoardDto> list = service.getList(start, perPage);
		
		if(list.size()==0) {
			return "redirect:list?pageNum="+(currentPage-1);
		}
		
		for(ReBoardDto dto:list) {
			dto.setCnt(adao.getAnswerList(dto.getNum()).size());
		}
		
		AnswerDao adao = new AnswerDao();
		// model에 저장
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
