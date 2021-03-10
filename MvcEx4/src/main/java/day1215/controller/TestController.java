package day1215.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@GetMapping("/")
	public ModelAndView test1() {
		ModelAndView model = new ModelAndView();
		model.addObject("address", "서울시 강남구");
		model.addObject("today", new Date());
		model.setViewName("board/show");
		return model;
	}
}
