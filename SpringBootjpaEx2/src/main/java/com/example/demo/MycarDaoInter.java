package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/*
 * public interface MycarDaoInter extends CrudRepository<MyCarDto, Long>{ 
 * // JpaRepository도 같은데 더 다양한 함수 많음, 함수명만 좀 다름
 * 
 * }
 */

public interface MycarDaoInter extends JpaRepository<MyCarDto, Long>{
	
	
}