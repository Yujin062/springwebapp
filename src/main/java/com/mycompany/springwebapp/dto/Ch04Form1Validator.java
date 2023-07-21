package com.mycompany.springwebapp.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch04Form1Validator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		log.info("실행");
		boolean check = Ch04Form1.class.isAssignableFrom(clazz);
		return check;
	}
	@Override
	public void validate(Object target, Errors errors) {
		log.info("실행");
		Ch04Form1 ch04Form1 = (Ch04Form1) target;
		
		//param1 검사
		String param1 = ch04Form1.getParam1();
		if(param1 == null || param1.equals("")) {
			errors.rejectValue("param1", "errors.form1.param1.required", "필수 입력");
		}else if(param1.length() < 8){
			errors.rejectValue("param1", "errors.form1.param1.minlength", "최소 8자 입력");	
		}else if(param1.length() > 15) {
			errors.rejectValue("param1", "errors.form1.param1.maxlength", "최대 15자 입력");			
		}
	}
}
