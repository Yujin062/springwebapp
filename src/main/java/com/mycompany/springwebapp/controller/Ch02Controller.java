package com.mycompany.springwebapp.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.springwebapp.dto.Ch02Dto;
import com.mycompany.springwebapp.dto.Ch02FileInfo;
import com.mycompany.springwebapp.interceptor.Auth;
import com.mycompany.springwebapp.interceptor.Auth.Role;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch02")
public class Ch02Controller {
	 //view 이름을 string으로 바로 받아서 리턴
	 @RequestMapping("/content")
	 public String content() {
		 return "ch02/content";
	 }
	
	/*//view이름을 ModelAndView 객체안에 넣어서 객체를 리턴
	@RequestMapping("/content")
	 public ModelAndView content() {
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("ch02/content");
		 return mav;
	 }*/
	 //@GetMapping("/method")
	 @RequestMapping(value="/method", method=RequestMethod.GET)
	 public String method1(String bkind, int bno) {
		 log.info("bkind: " + bkind);
		 log.info("bno: " + bno);
		 return "ch02/content";
	 }
	 //@PostMapping("/method")
	 @RequestMapping(value="/method", method=RequestMethod.POST)
	 public String method2(String bkind, int bno) {
		 log.info("bkind: " + bkind);
		 log.info("bno: " + bno);
		 return "ch02/content";
	 }
	 
	 //@PutMapping("/method")
	 @RequestMapping(value="/method", method=RequestMethod.PUT)
	 public void method3(@RequestBody Ch02Dto dto, HttpServletResponse response) throws Exception{
		 log.info("bkind: " + dto.getBkind());
		 log.info("bno: " + dto.getBno());

		 JSONObject root = new JSONObject();
		 root.put("result", "success");
		 String responseJson = root.toString(); // {"result":"success"}
		 
		 response.setContentType("application/json; charset=UTF-8");
		 PrintWriter pw = response.getWriter();
		 pw.print(responseJson);
		 pw.flush();
		 pw.close();
		 
	 }
	 //@DeleteMapping("/method")
	 @RequestMapping(value="/method", method=RequestMethod.DELETE)
	 public void method4(@RequestBody String json, HttpServletResponse response) throws Exception {
		 JSONObject jsonObject = new JSONObject(json);
		 int bno = jsonObject.getInt("bno");
		 log.info("bno: " + bno);
		 
		 JSONObject root = new JSONObject();
		 root.put("result", "success");
		 String responseJson = root.toString(); // {"result":"success"}
		 
		 response.setContentType("application/json; charset=UTF-8");
		 PrintWriter pw = response.getWriter();
		 pw.print(responseJson);
		 pw.flush();
		 pw.close();
	 }
	 
	 @GetMapping("/ajax1")
	 public String ajax1(){
		 return "ch02/fragmentHtml";
	 }
	 
	 @GetMapping("/ajax2")
	 public void ajax2(HttpServletResponse response) throws Exception{
		 JSONObject root = new JSONObject();
		 root.put("fileName", "photo10.jpg");
		 String responseJson = root.toString(); // {"result":"success"}
		 
		 //직접 응답을 생성
		 response.setContentType("application/json; charset=UTF-8");
		 PrintWriter pw = response.getWriter();
		 pw.print(responseJson);
		 pw.flush();
		 pw.close();
	 }
	 
	 @GetMapping(value="/ajax3", produces="application/json; charset=UTF-8")
	 @ResponseBody //ajax3에 응답을 할 때  produces로 응답을 하고 응답 바디에 바로 들어감(jsp로 forward되지 않고 리턴값을 응답 본문에 바로 싣기)
	 public String ajax3() {
		 JSONObject root = new JSONObject();
		 root.put("fileName", "photo6.jpg");
		 String responseJson = root.toString(); 
		 return responseJson;
	 }
	 
	 @GetMapping(value="/ajax4", produces="application/json; charset=UTF-8")
	 @ResponseBody //리턴값을 JSON으로 변환(Jackson-databind 라이브러리가 필요함)해서 응답본문에 바로 싣기
	 public Ch02FileInfo ajax4() {
		 Ch02FileInfo fileinfo = new Ch02FileInfo();
		 fileinfo.setFileName("photo9.jpg");
		 return fileinfo;
	 }
	 
	 @GetMapping("/fileDownload")
	 public void fileDownload(HttpServletRequest request, HttpServletResponse response) throws Exception{
	      String fileName = "photo12.jpg";
	      String filePath = "/resources/images/photo/" + fileName;
	      filePath = request.getServletContext().getRealPath(filePath);
	      log.info(filePath);
	      
	      
	      //응답 헤드에 Content-Type 추가
	      String mimeType = request.getServletContext().getMimeType(filePath);
	      response.setContentType(mimeType); //응답내용에 따라 ContentType을 정확히 지정해 함
	      
	      //응답 헤드에 한글 이름의 파일명을 ISO-8859-1 문자셋으로 인코딩해서 추가
	      String userAgent = request.getHeader("User-Agent");
	      if(userAgent.contains("Trident")|| userAgent.contains("MSIE")) {
	    	  //IE
	    	  fileName = URLEncoder.encode(fileName,"UTF-8");
	    	  log.info("IE: " + fileName);
	      }else {
	    	 //Chrome, Edge, FireFox, Safari 
	    	  fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
	    	  log.info("Chrome: " + fileName);
	      }
	      response.setHeader("Content-Disposition", "attachment; fileName=\"" + fileName + "\"" );//response.setHeader가 없으면 브라우저에 바로 보여줄 수 있으면 보여줌
	      																					      // 바로 보여줄 수 없으면 파일이 다운로드됨
	      
	      //응답 본문에 파일데이터 싣기
	      OutputStream os = response.getOutputStream();
	      Path path = Paths.get(filePath);
	      Files.copy(path, os);
	      os.flush();
	      os.close();
	 }
	 
	 //요청할 때 실행하기 전 ADMIN권한이 있는지 확인
	 @RequestMapping("/filterAndInterceptor")
	 @Auth(Role.ADMIN)
	 public String adminMethod() {
		 log.info("실행");
		 return "ch02/adminPage";
	 }
}


