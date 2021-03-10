package board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import board.service.BoardServiceInter;
import spring.dto.ReBoardDto;
import upload.util.SpringFileWriter;

@Controller
public class BoardWriteController {
	
	@Autowired
	private BoardServiceInter service;
	
	@GetMapping("/board/writeform")
	public ModelAndView writeForm(
			@RequestParam(value = "num", defaultValue = "0") String num,
			@RequestParam(value = "regroup", defaultValue = "0") int regroup,
			@RequestParam(value = "restep", defaultValue = "0") int restep,
			@RequestParam(value = "relevel", defaultValue = "0") int relevel,
			@RequestParam(defaultValue = "1") String pageNum
								) {
		ModelAndView mview = new ModelAndView();
		mview.addObject("num", num);
		mview.addObject("regroup", regroup);
		mview.addObject("restep", restep);
		mview.addObject("relevel", relevel);
		mview.addObject("pageNum", pageNum);
		mview.setViewName("/sub/board/writeform");
		
		return mview;
	}
	
	// ������
	@PostMapping("/board/write")
	public String write(
			@ModelAttribute ReBoardDto dto,
			HttpServletRequest request,
			@RequestParam String pageNum
			) {
		// ���� ���ε�
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		System.out.println(path);
		SpringFileWriter writer = new SpringFileWriter();
		String upload="";
		
		for(MultipartFile file : dto.getFiles()) {
			// ���ε� ���Ѱ�� ù������ ���ϸ��� ���ڿ�
			if(file.getOriginalFilename().length()==0) {
				upload = "no";
				break;
			}
			
			// ���ϸ� ������ upload�� �߰�
			String changeName = writer.chageFilename(file.getOriginalFilename());
			upload += changeName + ",";
			
			// �̹��� save ������ ����
			writer.writeFile(file, changeName, path);
		}
		
		// ������ �ĸ� ����
		if(!upload.equals("no")) {
			upload = upload.substring(0, upload.length()-1);
		}
		
		// dto�� ����
		dto.setUpload(upload);
		// db insert
		service.insertBoard(dto);
		
		return "redirect:list?pageNum=" + pageNum;
	}
}
