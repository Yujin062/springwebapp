package com.mycompany.springwebapp.dao;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

//기본 생성자를 이용해 자동적으로 객체가 만들어짐
@Repository
@Slf4j
public class Ch12DaoByAnnotation2{
	public Ch12DaoByAnnotation2() {
		log.info("실행");
	}
	public void method() {
		log.info("실행");
	}
}
