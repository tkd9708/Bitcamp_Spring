package day1215.spring.ex5;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@GetMapping("/")
	public String form1() {
		// formtag/myform1으로 포워드
		return "formtag/myform1";
	}
	
	@GetMapping("/read")
	public ModelAndView dataRead(
	/* @RequestParam("food") String food */
			@RequestParam String food // name과 읽을 변수명이 같을 경우 name 생략 가능
			) {
		
		ModelAndView model = new ModelAndView();
		System.out.println(food);
		
		// model에 저장
		model.addObject("food", food);
		model.setViewName("formtag/myfood");
		
		return model;
	}
}
