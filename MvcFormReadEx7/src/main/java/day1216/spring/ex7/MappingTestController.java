package day1216.spring.ex7;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MappingTestController {
	
	@GetMapping("/mapping")
	public String gomapping() {
		return "views/mappingtest";
	}
	
	// �������� �����ּҰ� ���� ������ ó���ϰ����� ���
	@GetMapping({"/board/list", "/guest/list", "/member/list"})
	public String list() {
		return "views/list";
	}
	
	@GetMapping("/shop/{path1}")
	public String changeUrl(Model model, @PathVariable("path1") String p1) {
		if(p1.equals("cart"))
			model.addAttribute("msg", "��ٱ����� ������ ����߾��!");
		else if(p1.equals("list"))
			model.addAttribute("msg", "������ ��ü ����� ����߾��!");
		else if(p1.equals("save"))
			model.addAttribute("msg", "������ ��ǰ�� �����߾��!");
		
		model.addAttribute("mypath", p1);
		return "views/list2";
	}
	
	// �����ּҰ� ��ĥ��� �����ּҰ� Ȯ���ϰ� ���ǵ� �޼��尡 �켱 ȣ��ȴ�.
	// ���� ���� ���� �ƴ� �Ʒ� ���� ȣ���
	@GetMapping("/shop/list")
	public String goList(Model model) {
		model.addAttribute("msg", "��ǰ ����ε� ������ �������� ó���Ұſ���");
		model.addAttribute("mypath", "list");
		
		return "views/list2";
	}
}
