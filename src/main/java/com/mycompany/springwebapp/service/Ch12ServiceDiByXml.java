package com.mycompany.springwebapp.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.springwebapp.dao.Ch12DaoByXml1;
import com.mycompany.springwebapp.dao.Ch12DaoByXml2;
import com.mycompany.springwebapp.dao.Ch12DaoByXml3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch12ServiceDiByXml {
	//필드
	private Ch12DaoByXml1 daoxml1;
	private Ch12DaoByXml2 daoxml2;
	private Ch12DaoByXml3 daoxml3;
	//생성자
	public Ch12ServiceDiByXml() {}
	//생성자
	public Ch12ServiceDiByXml(Ch12DaoByXml2 daoByXml2) {
		log.info("실행");
		this.daoxml2 = daoByXml2;
	}
	
	//setter
	public void setCh12DaoByXml1(Ch12DaoByXml1 daoByXml1) {
		log.info("실행");
		this.daoxml1 = daoByXml1;
	}
	public void setCh12DaoByXml2(Ch12DaoByXml2 daoByXml2) {
		log.info("실행");
		this.daoxml2 = daoByXml2;
	}
	public void setCh12DaoByXml3(Ch12DaoByXml3 daoByXml3) {
		log.info("실행");
		this.daoxml3 = daoByXml3;
	}
	
	//인스턴스 메소드
	public void method() {
		daoxml1.method();
		daoxml2.method();
		daoxml3.method();
	}
}
