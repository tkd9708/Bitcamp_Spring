package day1215.spring.ex6;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
	public String form() {
		return "stu/stuform";
	}
	
	@GetMapping("/sturead")
	public ModelAndView dataRead(
			@RequestParam String name, String score
			) {
		ModelAndView model = new ModelAndView();
		
		model.addObject("name", name);
		model.addObject("score", score);
		model.setViewName("stu/stuscore");
		
		return model;
	}
	
}
