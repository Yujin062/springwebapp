package com.mycompany.springwebapp.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch14")
public class Ch14Controller {
	@RequestMapping("/content")
	public String content() {
		log.info("실행");
		return "ch14/content";
	}
	
	@RequestMapping("/before")
	public String before() {
		log.info("실행");
		return "redirect:/ch14/content";
	}
}
