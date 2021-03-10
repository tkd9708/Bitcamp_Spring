package day1215.spring.ex3;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller  // xml�� bean���� ���
public class HelloController {

	// POJO ������ ��Ʈ�ѷ������� �޼��嵵 ������� �������� ����������.
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public String one(Model model) {
		// model�� �����͸� �����ϸ� request�� �����ϴ� �Ͱ� ����.
		model.addAttribute("name", "���缮");
		model.addAttribute("message", "Happy Day!!!");
		
		// /WEB-INF/views/result1.jsp�� �������
		return "result1"; // ������Ǵ� ���ϸ��� �ǹ�
	}
	
	@RequestMapping("/my") // ������ Get���
	public ModelAndView two() {
		//ModelAndView = Model + View�� ���ĳ��� ������ Ŭ����
		ModelAndView model = new ModelAndView();
		
		// ������ ����
		model.addObject("emp", "�Ｚ");
		model.addObject("sawonname", "��ȣ��");
		model.addObject("pay", 2300000);
		
		// �������� ���ϸ� ����
		model.setViewName("result2");
		return model;
	}
	
	@GetMapping("/my/hello") // Get����� ���� (������ ���� 5���� ����)
	public String three(Model model, HttpSession session) {
		model.addAttribute("msg", "����° �޼����Դϴ�");
		session.setAttribute("login", "ok");
		return "result3";
	}
}
