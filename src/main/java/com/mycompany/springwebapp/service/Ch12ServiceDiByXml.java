package com.mycompany.springwebapp.service;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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
	public Ch12ServiceDiByXml() {
		log.info("실행1");
	}
	//생성자
	public Ch12ServiceDiByXml(Ch12DaoByXml1 daoByXml1) {
		log.info("실행2");
		this.daoxml1 = daoByXml1;
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
	public void setCollection1(List<String> list) {
		log.info("실행");
		for(String item: list) {
			log.info(item);			
		}
	}
	public void setCollection2(Set set) {
		log.info("실행");
		log.info("아이템 수: " + set.size());
	}
	public void setCollection3(Map<String, Object>map) {
		log.info("실행");
		log.info("아이템 수: " + map.size());
	}
	public void setCollection4(Properties prop) {
		log.info("실행");
		log.info("아이템 수: " + prop.size());
	}
	
	//인스턴스 메소드
	public void method() {
		daoxml1.method();
		daoxml2.method();
		daoxml3.method();
	}
}
