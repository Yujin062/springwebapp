package com.mycompany.springwebapp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.dao.Ch13BoardDaoOld;
import com.mycompany.springwebapp.dto.Ch13Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch13")
public class Ch13Controller {
	@Resource
	private Ch13BoardDaoOld boardDaoOld;
	
    @RequestMapping("/content")
    public String content(HttpSession session) {
      
	   return "ch13/content";
    }
    
   @GetMapping("/insertBoard")
   public String insertBoard() {
	   log.info("실행");
	   
	   Ch13Board board = new Ch13Board();
	   board.setBtitle("괴롭지 ?");
	   board.setBcontent("한번만 성공해, 그 뒤로는 쉬워~");
	   board.setMid("user");
	   
	   boardDaoOld.insert(board);
	   
	   return "redirect:/ch13/content";
   }
   
   @GetMapping("/getBoardList")
   public String getBoardList() {
	   List<Ch13Board> list = boardDaoOld.selectAll();
	   log.info(list.toString());
	   return "redirect:/ch13/content";
   }
   
   //update는 select를 한번 하고 변경해야함(안그러면 변경 안한 데이터 모두 null)
   @GetMapping("/updateBoard")
   public String updateBoard() {
	   Ch13Board board = boardDaoOld.selectByBno(1);
	   board.setBtitle("괴롭지 ?");
	   board.setBcontent("한번만 성공해, 그 뒤로는 쉬워~");
	   
	   boardDaoOld.updateByBno(board);
	   return "redirect:/ch13/content";
   }
   @GetMapping("/deleteBoard")
   public String deleletBoard(int bno) {
	   boardDaoOld.deleteByBno(bno);
	   return "redirect:/ch13/content";
   }
 
}