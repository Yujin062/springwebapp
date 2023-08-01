package com.mycompany.springwebapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Ch14Aspect3After {
	@After("execution(public * com.mycompany.springwebapp.controller.Ch14Controller.after*(..))")
	public void Method() {
		log.info("실행");
	}
}
