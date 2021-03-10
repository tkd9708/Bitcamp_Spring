package day1215.spring.ex3;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller  // xml에 bean으로 등록
public class HelloController {

	// POJO 형태의 컨트롤러에서는 메서드도 마음대로 디자인이 가능해졌다.
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public String one(Model model) {
		// model에 데이터를 저장하면 request에 저장하는 것과 같다.
		model.addAttribute("name", "유재석");
		model.addAttribute("message", "Happy Day!!!");
		
		// /WEB-INF/views/result1.jsp로 포워드됌
		return "result1"; // 포워드되는 파일명을 의미
	}
	
	@RequestMapping("/my") // 생략시 Get방식
	public ModelAndView two() {
		//ModelAndView = Model + View를 합쳐놓은 형태의 클래스
		ModelAndView model = new ModelAndView();
		
		// 데이터 저장
		model.addObject("emp", "삼성");
		model.addObject("sawonname", "강호동");
		model.addObject("pay", 2300000);
		
		// 포워드할 파일명 지정
		model.setViewName("result2");
		return model;
	}
	
	@GetMapping("/my/hello") // Get방식의 매핑 (스프링 버전 5부터 가능)
	public String three(Model model, HttpSession session) {
		model.addAttribute("msg", "세번째 메서드입니다");
		session.setAttribute("login", "ok");
		return "result3";
	}
}
