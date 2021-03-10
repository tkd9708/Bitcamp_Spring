package day1216.spring.ex7;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// /sawon/list, /sawon/insert 등등 공통된 url의 앞부분을 클래스 위에서 따로 지정할 수 있다.

@Controller
@RequestMapping("/sawon")
public class MappingTest2Controller {

	@RequestMapping("/list")
	public String go1(Model model, HttpServletRequest request) {
		model.addAttribute("url", request.getRequestURI());
		
		return "views/list3";
	}
}
