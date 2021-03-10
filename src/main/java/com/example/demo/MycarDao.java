package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MycarDao {
	@Autowired
	MycarDaoInter daoInter;
	
	public void insertCar(MyCarDto dto) {
		daoInter.save(dto); // db에 insert
	}
	
//	public Iterable<MyCarDto> getAllDatas() {   // crud는 iterable
//		return daoInter.findAll();
//	}
	
	public List<MyCarDto> getAllDatas() {
		return daoInter.findAll();
	}
	
	public MyCarDto getDatas(Long num) {
		return daoInter.getOne(num);
	}
	
	public void update(MyCarDto dto) {
		daoInter.save(dto); // num값이 있으면 수정, 없으면 알아서 추가
	}
	
	public void delete(Long num) {
		daoInter.deleteById(num);
	}
}
