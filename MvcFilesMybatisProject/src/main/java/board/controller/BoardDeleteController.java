package board.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.service.BoardServiceInter;
import upload.util.SpringFileWriter;

@Controller
public class BoardDeleteController {
	
	@Autowired
	private BoardServiceInter service;
	
	@GetMapping("/board/deletepassform")
	public ModelAndView passform(@RequestParam String num, @RequestParam String pageNum) {
		ModelAndView mview = new ModelAndView();
		mview.addObject("num", num);
		mview.addObject("pageNum", pageNum);
		mview.setViewName("/sub/board/deletepassform");
		return mview;
	}
	
	@PostMapping("/board/passcheckdelete")
	public String passcheck(@RequestParam String num, @RequestParam String pageNum, @RequestParam String pass, HttpServletRequest request) {
		
		if(service.getCheckPass(num, pass)==0)
			return "/sub/member/passfail";
		
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		if(!service.getData(num).getUpload().equals("no")) {
			String[] s = service.getData(num).getUpload().split(",");
			for(String f : s) {
				File file = new File(path + "\\" + f);
				if(file.exists())
					file.delete();
			}
		}
		
		service.deleteBoard(num);
		
		return "redirect:list?pageNum=" + pageNum;
	}
}
