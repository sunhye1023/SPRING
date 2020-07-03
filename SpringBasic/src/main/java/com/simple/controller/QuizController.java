package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.QuizVO;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	//한번에 묶어서 화면처리를 해줄수도 있다
//	@RequestMapping({"/quiz01", "/quiz02", "/quiz03"})
//	public void view() {
//		
//	}
	
	@RequestMapping("/quiz01")
	public String quiz01() {
		
		return "quiz/quiz01";
	}
	
	
	@RequestMapping(value="/sendBirth", method=RequestMethod.POST)
	public String snedBirth(@ModelAttribute("vo") QuizVO vo) {
		
		System.out.println(vo.getYear()+vo.getMonth()+vo.getDay());
		
		return "quiz/quiz01_ok";
	}
	
	
	@RequestMapping("/quiz02")
	public String quiz02() {
		
		return "/quiz/quiz02";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute("vo") QuizVO vo) {
		
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		System.out.println(vo.getEmail());
		
		return "quiz/quiz02_ok";
	}
	
	@RequestMapping("/quiz03")
	public String quiz03() {
		
		return "quiz/quiz03";
	}
	
	@RequestMapping(value="/join2", method=RequestMethod.POST)
	public String join2(@ModelAttribute("vo") QuizVO vo,
						RedirectAttributes RA
			) {
		
		if(vo.getId().equals("")) {
			RA.addFlashAttribute("msgid", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
		} else if(!vo.getPw().equals(vo.getPw_check())) {
			RA.addFlashAttribute("msgpw", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		} else {
			return "quiz/quiz03_ok";
		}
		
	}
	
	
}
