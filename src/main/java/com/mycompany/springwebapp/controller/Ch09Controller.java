package com.mycompany.springwebapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch09")
public class Ch09Controller {
	@RequestMapping("/content")
	public String content(HttpSession session) {
		return "ch09/content";
	}
	
	@PostMapping("/fileupload")
	public String fileupload(String title, String desc, MultipartFile attach) {;
		log.info("title: " + title);
		log.info("desc: " + desc);
		log.info("originalFilename: " + attach.getOriginalFilename());
		log.info("contentType: " + attach.getContentType());
		log.info("file size: " + attach.getSize());
		
		return "redirect:/ch09/content";
	}
}
