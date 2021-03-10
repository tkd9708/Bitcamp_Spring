package rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import board.service.BoardServiceInter;
import spring.dto.MyCarDto;
import spring.dto.ReBoardDto;

// @RestController = @Controller + @ResponseBody
@RestController
public class TestRestController2 {

	@Autowired
	private BoardServiceInter service;
	
	@GetMapping("/rest4")
	public MyCarDto testRest4() {
		MyCarDto dto = new MyCarDto();
		dto.setNum("300");
		dto.setCarname("¸ð´×");
		dto.setCarcolor("ÃÊ·Ï");
		dto.setCarguip("2020-11-11");
		
		return dto;
	}
	
	@GetMapping("/rest5")
	public List<ReBoardDto> testRest5(){
		return service.getList(0, 3);
	}
	
	@GetMapping("/rest6")
	public String test6() {
		return "happy";
	}
	
	@GetMapping("/rest7")
	public Map<String, String> test7() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "happy");
		return map;
	}
}
