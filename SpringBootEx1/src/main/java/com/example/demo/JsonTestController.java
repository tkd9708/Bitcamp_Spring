package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.data.TestDto;

@RestController
public class JsonTestController {
	
	@GetMapping("/json1")
	public Map<String, String> getJson1(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "Happy Day");
		return map;
	}
	
	@GetMapping("/json2")
	public TestDto getJson2() {
		TestDto dto = new TestDto();
		dto.setSang("오렌지");
		dto.setSu(5);
		dto.setDan(1200);
		return dto;
	}
}
