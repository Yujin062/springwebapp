package com.mycompany.springwebapp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.dto.Ch13Board;
import com.mycompany.springwebapp.dto.Ch13Pager;
import com.mycompany.springwebapp.service.Ch13BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch13")
public class Ch13Controller {
	@Resource
	private Ch13BoardService boardService;
	
    @RequestMapping("/content")
    public String content(HttpSession session) {
      
	   return "ch13/content";
    }
    
   @GetMapping("/insertBoard")
   public String insertBoard() {
	   log.info("실행");
	   
		   
	   Ch13Board board = new Ch13Board();
	   board.setBtitle("행복해");
	   board.setBcontent("고생한 만큼, 실력을 향상시켜서 연봉 100000000000원을 받을 거야.");
	   board.setMid("user");
	   
	   //boardDaoOld.insert(board);
	   boardService.write(board);
	   //실제로 저장된 bno
	   log.info("저장된bno: " + board.getBno());
	 
	   
	   return "redirect:/ch13/content";
   }
   
   @GetMapping("/getBoardList")
   public String getBoardList() {
	   int totalRows = boardService.getTotalBoardNum();
	   Ch13Pager pager = new Ch13Pager(10, 5, totalRows, 1);
	   //List<Ch13Board> list = boardDaoOld.selectAll(pager);
	   List<Ch13Board> list = boardService.getList(pager);
	   for(Ch13Board board: list) {
		   log.info(list.toString());		   
	   }
	   return "redirect:/ch13/content";
   }
   
   //update는 select를 한번 하고 변경해야함(안그러면 변경 안한 데이터 모두 null)
   @GetMapping("/updateBoard")
   public String updateBoard() {
	   //Ch13Board board = boardDaoOld.selectByBno(1);
	   Ch13Board board = boardService.getBoard(8);
	   board.setBtitle("변경 함 ㅎㅎ");
	   board.setBcontent("룰루랄라룰루룰루");
	   
	   //boardDaoOld.updateByBno(board);
	   boardService.modify(board);
	   return "redirect:/ch13/content";
   }
   @GetMapping("/deleteBoard")
   public String deleletBoard() {  	
	   //boardDaoOld.deleteByBno(bno);
	   int bno = 8;
	   boardService.remove(bno);
	   
	   return "redirect:/ch13/content";
   }
 
}