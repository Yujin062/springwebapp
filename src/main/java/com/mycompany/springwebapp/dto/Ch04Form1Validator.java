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
		
	}
}
