package spring.controller.bit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
	
	@GetMapping({"/", "/home"})
	public String goMain() {
		
		return "/layout/main";
		// return "/layout/main"; // Ã¹¹øÂ° layout
	}
	
	
}
