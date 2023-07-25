package com.mycompany.springwebapp.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.springwebapp.dto.Ch09FileUpload;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch09")
public class Ch09Controller {
	@RequestMapping("/content")
	public String content(HttpSession session) {
		return "ch09/content";
	}
	
	/*@PostMapping("/fileupload")
	public String fileupload(String title, String desc, MultipartFile attach) throws Exception{
		log.info("title: " + title);
		log.info("desc: " + desc);
		log.info("originalFilename: " + attach.getOriginalFilename());
		log.info("contentType: " + attach.getContentType());
		log.info("file size: " + attach.getSize());
		
		//받은 파일을 영구적으로 저장하기
		//실제 서버에 저장되는 파일 이름(중복이 되면 안됌)
		String saveFilename = new Date().getTime() + "-" + attach.getOriginalFilename();
		String saveFilepath = "C:/OTI/uploadfiles/" + saveFilename;
		File file = new File(saveFilepath);
		attach.transferTo(file);
		
		return "redirect:/ch09/content";
	}*/
	@PostMapping("/fileupload")
	public String fileupload(Ch09FileUpload fileUpload) throws Exception{
		log.info("title: " + fileUpload.getTitle());
		log.info("desc: " + fileUpload.getDesc());
		log.info("originalFilename: " + fileUpload.getAttach().getOriginalFilename());
		log.info("contentType: " + fileUpload.getAttach().getContentType());
		log.info("file size: " + fileUpload.getAttach().getSize());
		
		//받은 파일을 영구적으로 저장하기
		//실제 서버에 저장되는 파일 이름(중복이 되면 안됌)
		String saveFilename = new Date().getTime() + "-" + fileUpload.getAttach().getOriginalFilename();
		String saveFilepath = "C:/OTI/uploadfiles/" + saveFilename;
		File file = new File(saveFilepath);
		fileUpload.getAttach().transferTo(file);
		
		return "redirect:/ch09/content";
	}
}
