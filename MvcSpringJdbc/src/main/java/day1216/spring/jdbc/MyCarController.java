package day1216.spring.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mycar.data.MyCarDao;
import mycar.data.MyCarDto;

@Controller
public class MyCarController {
	
	@Autowired
	MyCarDao dao;
	
	@RequestMapping({"/", "/list"})
	public ModelAndView list() {
		ModelAndView model = new ModelAndView();
		
		// db로부터 목록을 가져온다
		List<MyCarDto> list = dao.getAllDatas();
		// model에 저장
		model.addObject("totalCount", list.size());
		model.addObject("list", list);
		
		model.setViewName("mycar/list");
		return model;
	}
	
	@GetMapping("/carform")
	public String goForm() {
		return "mycar/writeform";
	}
	
	@PostMapping("/read")
	public String dataRead(@ModelAttribute MyCarDto dto) {
		// 데이터 db에 추가
		dao.insertCar(dto);
		
		// 목록페이지로 이동
		return "redirect:list";
	}
	
	@GetMapping("/updateform")
	public ModelAndView updateForm(@RequestParam String num) {
		ModelAndView model = new ModelAndView();
		MyCarDto dto = dao.getData(num);
		model.addObject("dto", dto);
		model.setViewName("mycar/updateform");
		
		return model;
	}

	// 수정 메소드
	@PostMapping("/update")
	public String updateForm(@ModelAttribute MyCarDto dto) {
		dao.updateCar(dto);
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam String num) {
		dao.deleteCar(num);
		return "redirect:list";
	}
}
