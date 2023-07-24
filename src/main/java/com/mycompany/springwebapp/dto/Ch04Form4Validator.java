package com.mycompany.springwebapp.dto;


import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.springwebapp.dto.Ch04Form1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch04Form4Validator implements Validator {@Override
   public boolean supports(Class<?> clazz) {
      log.info("실행");
      boolean check = Ch04Form3.class.isAssignableFrom(clazz);
      return check;
   }

   @Override
   public void validate(Object target, Errors errors) {
      log.info("실행");
      Ch04Form4 ch04Form4 = (Ch04Form4) target;
      
      //mid 검사
      String mid = ch04Form4.getMid();
      if(mid == null || mid.equals("")) {
    	 log.info("작성안함");
         errors.rejectValue("mid", "errors.form.required", "필수 입력(D)");
      } else if(mid.length() < 8) {
         errors.rejectValue("mid", "errors.form.minlength", new Object[] {8}, "최소 8자 입력(D)");
      } else if(mid.length() > 15) {
         errors.rejectValue("mid", "errors.form.maxlength", new Object[] {15},"최대 15자 입력(D)");
      }
      
      //mpassword 검사
      String mpassword = ch04Form4.getMpassword();
      if(mpassword == null ||  mpassword.equals("")) {
         errors.rejectValue("mpassword", "errors.form.required", "필수 입력(D)");
      }else if(mid.length() < 8) {
          errors.rejectValue("mpassword", "errors.form.minlength", new Object[] {8}, "최소 8자 입력(D)");
      } else if(mid.length() > 15) {
          errors.rejectValue("mpassword", "errors.form.maxlength", new Object[] {15},"최대 15자 입력(D)");
      }else {
    	  String regExp ="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$";
    	  boolean result = Pattern.matches(regExp, mpassword);
          if(result == false) {
             errors.rejectValue("mpassword", "errors.form.format", "형식에 맞지 않음(D)");
          }
      }
   }   
}