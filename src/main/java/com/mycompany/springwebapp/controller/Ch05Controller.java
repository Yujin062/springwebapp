package com.mycompany.springwebapp.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch05")
public class Ch05Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch05/content";
	}
	
	@GetMapping("/getHeaderValue")
	public String getHeaderValue(@RequestHeader("User-Agent") String userAgent,
			HttpServletRequest request) {
		log.info("User-Agent: " + userAgent);
		log.info("client IP: " + request.getRemoteAddr());
		return "redirect:/ch05/content";
	}
}
