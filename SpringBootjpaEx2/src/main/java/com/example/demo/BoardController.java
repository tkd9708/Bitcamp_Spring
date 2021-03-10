package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	@Autowired
	MycarDao dao;

	@GetMapping({"/", "/list"})
	public ModelAndView list() {
		ModelAndView mview = new ModelAndView();
		//ArrayList<MyCarDto> list = (ArrayList<MyCarDto>)dao.getAllDatas();
		List<MyCarDto> list = dao.getAllDatas();
		
		mview.addObject("list", list);
		mview.addObject("totalCount", list.size());
		mview.setViewName("list");
		return mview;
	}
	
	@GetMapping("/carform")
	public String form() {
		return "writeform";
	}
	
	@PostMapping("/read")
	public String read(@ModelAttribute MyCarDto dto) {
		dao.insertCar(dto);
		return "redirect:list";
	}
	
	@GetMapping("/updateform")
	public ModelAndView updateform(@RequestParam Long num) {
		ModelAndView mview = new ModelAndView();
		mview.addObject("dto", dao.getDatas(num));
		mview.setViewName("updateform");
		
		return mview;
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute MyCarDto dto) {
		dao.update(dto);
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Long num) {
		dao.delete(num);
		
		return "redirect:list";
	}
}
