package com.mycompany.springwebapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.dto.Ch08Item;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch08")
public class Ch08Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch08/content";
	}
	
	@PostMapping("/addCart")
	public String addCart(Ch08Item item, HttpSession session){
		//세션에서 카트 가져오기
		List<Ch08Item> cart = (List<Ch08Item>) session.getAttribute("cart");
		//세션에 카트가 없을 경우, 새로 생성해서 카트에 저장
		if(cart == null) {
			cart = new ArrayList<Ch08Item>();
			session.setAttribute("cart", cart);
		}
		//카트에 해당 아이템이 있는지 조사
		boolean exist = false;
		for(Ch08Item cartItem: cart) {
			if(cartItem.getName().equals(item.getName())) {
				//카트에 기존아이템이 있을 경우, 양만 수정
				cartItem.setAmount(cartItem.getAmount() + item.getAmount());
				exist = true;
			}
		}
		//카트에 없는 새로운 아이탬일 경우
		if(exist == false) {
			cart.add(item);
		}
		return "redirect:/ch08/content";
	}
}
