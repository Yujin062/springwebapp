package com.mycompany.springwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.dto.Ch11Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch11")
public class Ch11Controller {
   
   @RequestMapping("/content")
   public String content() {
      return "ch11/content";
   }
   
   @GetMapping("/form1")
   public String form1(@ModelAttribute("member") Ch11Member member) {
	   return "ch11/form1";
   }
   
}