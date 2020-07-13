package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.BoardVO;
import com.simple.service.BoardService;
import com.simple.service.BoardServiceImpl;

@Controller
@RequestMapping("/service")
public class BoardController {

	@Autowired
	private BoardService boardService;
	//private BoardServiceImpl boardService;
	
	//화면요청
	@RequestMapping("/boardRegister")
	public String boardRegister() {
		
		return "/service/boardRegister";
	}
	
	//게시글 등록
	@RequestMapping(value="/boardForm", method=RequestMethod.POST)
	public String boardForm(BoardVO vo) {
		
		boardService.boardRegist(vo);
		
		return "service/boardResult";
	}
	
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		
		ArrayList<BoardVO> list = boardService.boardList();
		
		model.addAttribute("list", list);
		
		return "service/boardList";
	}
	
	@RequestMapping("/boardDelete")
	public String boardDelete(@RequestParam("num") int num,
							  RedirectAttributes RA
			) {
		
		boardService.boardDelete(num);
		RA.addFlashAttribute("num", num);
		
		return "redirect:/service/boardList";
	}
	
}
