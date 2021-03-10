package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "mycar2") // 테이블이 없을경우 실행하면 자동으로 테이블이 생성된다. 기존에 있다면 업데이트
@Data
public class MyCarDto {
	@Id // 각 엔터티를 구별할 수 있도록 식별아이디를 갖도록 설계
	@GeneratedValue(strategy = GenerationType.AUTO) // DB에 맞게 자동발생
	private Long num;
	@Column(name = "carname")
	private String carname;
	@Column(name = "carprice")
	private int carprice;
	@Column(name = "carcolor")
	private String carcolor;
	@Column(name = "carguip")
	private String carguip;
	
	/*
	 * @CreationTimestamp // 엔터티가 생성되는 시점의 시간등록
	 * private Timestamp writeday;
	 * */
}
