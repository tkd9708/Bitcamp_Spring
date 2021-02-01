package spring.controller.bit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.dao.MyCarDao;
import spring.dto.MyCarDto;

@Controller
public class MyCarController {

	// dao ����
	@Autowired // dao �ڵ� ����
	MyCarDao dao;
	
	@GetMapping("/mycar/list")
	public String goCarList(Model model) {
		
		// ��ü ���� ���
		int totalCount = dao.getTotalCount();
		
		// ��ü ������ ���
		List<MyCarDto> list = dao.getAllDatas();
		
		// model�� ����
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		// return�� Ÿ���� ����
		// /sub(�ι�° ���̾ƿ�)/mycar(������)/list(���ϸ�)
		return "/sub/mycar/list";
	}
	
	@GetMapping("/mycar/carform")
	public String mycarForm() {
		return "/sub/mycar/writeform";
	}
	
	@PostMapping("/mycar/read")
	public String mycarRead(@ModelAttribute MyCarDto dto) {
		dao.insertCar(dto);
		return "redirect:list";
	}
	
	
	  @GetMapping("/mycar/updateform") 
	  public ModelAndView updateForm(@RequestParam String num) { 
		  ModelAndView model = new ModelAndView(); 
		  model.addObject("dto", dao.getData(num)); 
		  model.setViewName("/sub/mycar/updateform"); 
		  return model;
	  }
	 
	
	/*
	 * @GetMapping("/mycar/updateform") public String updateForm(@RequestParam
	 * String num, Model model) {
	 * 
	 * model.addAttribute("dto", dao.getData(num)); return "/sub/mycar/updateform";
	 * }
	 */
	@PostMapping("/mycar/update")
	public String update(@ModelAttribute MyCarDto dto) {
		dao.updateCar(dto);
		return "redirect:list";
	}
	
	@GetMapping("/mycar/delete")
	public String delete(@RequestParam String num) {
		dao.deleteCar(num);
		return "redirect:list";
	}
}
