package com.mycompany.springwebapp.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.dto.Ch04Form1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch04")
public class Ch04Controller {
	 //view 이름을 string으로 바로 받아서 리턴
	 @RequestMapping("/content")
	 public String content() {
		 return "ch04/content";
	 }
	 @PostMapping("/method1")
	 //pom.xml에 validation-api 라이브러리 의존설정 필요
	 public String method1(@Valid Ch04Form1 form1) {
		 log.info("param1: " + form1.getParam1());
		 log.info("param2: " + form1.getParam2());
		 log.info("param3: " + form1.getParam3());
		 log.info("param4: " + form1.isParam4());
		 log.info("param5: " + form1.getParam5());
		 return "redirect:/ch04/content";
	 }
}


