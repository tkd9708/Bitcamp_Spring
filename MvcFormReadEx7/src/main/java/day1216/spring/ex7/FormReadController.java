package day1216.spring.ex7;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import day1216.data.ShopDto;

@Controller
public class FormReadController {

	@GetMapping("/form1")
	public String form1() {
		return "formtag/myform1";
	}
	
	@GetMapping("/form2")
	public String form2() {
		return "formtag/myform2";
	}
	
	@GetMapping("/form3")
	public String form3() {
		return "formtag/myform3";
	}
	
	@PostMapping("/read1")
	public ModelAndView readForm1(
			@RequestParam String name,
			@RequestParam int java,
			@RequestParam int spring,
			// pageNum ���� �Ѿ���� intŸ������ ������, ���� �ȳѾ����(null�� ���) �ʱⰪ�� "1"�� �ش�.
			@RequestParam(value = "pageNum", defaultValue = "1") int currentPage
			) {
		ModelAndView model = new ModelAndView();
		
		// request�� ����
		model.addObject("name", name);
		model.addObject("java", java);
		model.addObject("spring", spring);
		model.addObject("tot", java+spring);
		model.addObject("avg", (java+spring)/2.0);
		model.addObject("currentPage", currentPage);

		// ������ ���
		model.setViewName("result/formresult1");
		return model;
	}
	
	@RequestMapping(value = "/read2", method = RequestMethod.POST)
	// @PostMapping("/read2") // ���� �ڵ�� ����
	// @ModelAttribute : ���� �̸��� ����� �о�´�. 
	// �̶�, �ش� dto�� request�� �����(Ŭ����Ÿ�� �̸�����) ù���ڴ� �ҹ��� : shopDto
	// request�� �ٸ��̸����� �����ϰ� ���� ��� @ModelAttribute("dto") �̷��� �ָ� request�� dto�� �����
	public String formRead2(@ModelAttribute ShopDto dto) { 
		return "result/formresult2";
	}
	
	@PostMapping("/read3")
	// map���� ���� ��� ���� name�� key������, �Է°��� value������ ����
	public ModelAndView formRead3(@RequestParam Map<String, String> map) {
		ModelAndView model = new ModelAndView();
		model.addObject("name", map.get("name"));
		model.addObject("blood", map.get("blood"));
		model.addObject("age", map.get("age"));
		model.addObject("hp", map.get("hp"));
		model.addObject("addr", map.get("addr"));
		model.setViewName("result/formresult3");
		return model;
	}
}
