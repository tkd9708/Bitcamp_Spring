package board.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class BoardUpdateController {
	
	@Autowired
	private BoardServiceInter service;
	
	@GetMapping("/board/updatepassform")
	public ModelAndView passform(
			@RequestParam String num,
			@RequestParam String pageNum
			) {
		ModelAndView mview = new ModelAndView();
		
		mview.addObject("num", num);
		mview.addObject("pageNum", pageNum);
		
		mview.setViewName("/sub/board/updatepassform");
		return mview;
	}
	
	@PostMapping("/board/passcheck")
	public String passcheck(Model model, @RequestParam String num, @RequestParam String pageNum, @RequestParam String pass) {
		if(service.getCheckPass(num, pass)==0) {
			return "/sub/member/passfail";
		}
		
		model.addAttribute("dto", service.getData(num));
		model.addAttribute("pageNum", pageNum);
		
		return "/sub/board/updateform";
	}
	
	@PostMapping("/board/update")
	public String updateBoard(
			@ModelAttribute ReBoardDto dto,
			@RequestParam String pageNum,
			HttpServletRequest request,
			Model model
			) {
		
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		System.out.println(path);
		SpringFileWriter writer = new SpringFileWriter();
		String uploads="";
		
		for(MultipartFile file:dto.getFiles()) {
			if(file.getOriginalFilename().length()==0) {
				uploads = null;
				break;
			}
			String changeName = writer.chageFilename(file.getOriginalFilename());
			uploads += changeName + ",";
			writer.writeFile(file, changeName, path);
			
		}
		
		if(uploads != null) {
			uploads = uploads.substring(0, uploads.length()-1);
			
			String deleteFiles = service.getData(dto.getNum()).getUpload();
			if(!service.getData(dto.getNum()).getUpload().equals("no")) {
				String[] s = deleteFiles.split(",");
				for(String f:s) {
					File file = new File(path + "\\" + f);
					if(file.exists())
						file.delete();
				}
			}
		}
		
		dto.setUpload(uploads);
		service.updateBoard(dto);
		
		return "redirect:content?num=" + dto.getNum() + "&pageNum=" + pageNum;
	}
}
