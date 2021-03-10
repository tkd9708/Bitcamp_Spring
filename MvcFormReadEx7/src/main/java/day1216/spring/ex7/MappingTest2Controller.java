package day1216.spring.ex7;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// /sawon/list, /sawon/insert ��� ����� url�� �պκ��� Ŭ���� ������ ���� ������ �� �ִ�.

@Controller
@RequestMapping("/sawon")
public class MappingTest2Controller {

	@RequestMapping("/list")
	public String go1(Model model, HttpServletRequest request) {
		model.addAttribute("url", request.getRequestURI());
		
		return "views/list3";
	}
}
