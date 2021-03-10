package rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import board.service.BoardServiceInter;
import spring.dto.MyCarDto;
import spring.dto.ReBoardDto;

@Controller
public class TestRestController1 {

	@Autowired
	private BoardServiceInter service;
	
	// @ResponseBody : �ڹٰ�ü�� json���·� ��ȯ�ؼ� �������� ���
	@GetMapping("/rest1")
	public @ResponseBody MyCarDto testRest1() {
		MyCarDto dto = new MyCarDto();
		dto.setNum("100");
		dto.setCarname("�׷���");
		dto.setCarcolor("�Ķ�");
		dto.setCarguip("2020-10-10");
		
		return dto;
	}
	
	@GetMapping("/rest2")
	public ResponseEntity<MyCarDto> testRest2() {
		MyCarDto dto = new MyCarDto();
		dto.setNum("200");
		dto.setCarname("�ҳ�Ÿ");
		dto.setCarcolor("���");
		dto.setCarguip("2022-10-10");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=UTF-8");
		
		return new ResponseEntity<>(dto, headers, HttpStatus.OK);
	}
	
	// db�κ��� ReBoard �����͸� ������ json���� ��ȯ�غ���
	@GetMapping("/rest3")
	public @ResponseBody List<ReBoardDto> testRest3(){
		return service.getList(0, 5);
	}
}
