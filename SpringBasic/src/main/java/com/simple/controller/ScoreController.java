package com.simple.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ScoreVO;
import com.simple.service.ScoreService;
import com.simple.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ScoreController {

	//service와 dao의 연결
	
	//1st(좋은 방법은 아니다)
	//ScoreServiceImpl service = new ScoreServiceImpl();
	//private ScoreServiceImpl service;
	//전역변수로 만들어주면 service를 모든 메서드가 사용할 수 있다.
	
	
	//2nd
	//@Resource(name="scoreService") //이름으로 찾아 강제연결(service라는 이름을 가진 빈을 찾아서 주입)
	//@Autowired
	//private ScoreServiceImpl scoreService;
	
	
	//3nd
	//- @Controller, @Service, @Component, @Repository 자동생성 어노테이션을 붙이고, 
	//해당패키지를 스캔명령으로 읽어서 빈으로 생성후에 자동주입 명령
	@Autowired
	private ScoreService scoreService;
	//private ScoreServiceImpl scoreService; 
	//ScoreServiceImpl.java의 @Service("빈의 아이디")에서 빈의아이디와 동일하게 해준다.
	
	//화면처리
	@RequestMapping("/scoreRegist")
	public void scoreRegist() {
		
	}
	
	//점수등록 요청
	@RequestMapping("/scoreForm")
	public String scoreForm(ScoreVO vo) {
		
		//service.scoreRegist(vo);
		scoreService.scoreRegist(vo);
		
		//처리
		
		return "service/scoreResult";
	}
	
	//점수화면 요청
	@RequestMapping("/scoreList")
	public String scoreList(Model model) {
		
		//서비스에 있는 값을 가져와야 결과화면에 띄울수 있습니다.
		//ScoreServiceImpl.java에 있는 scoreList()호출
		ArrayList<ScoreVO> list = scoreService.scoreList();
		
		model.addAttribute("list", list); //화면으로 모델전달
		//model.addAttribute("list", scoreService.scoreList()); //이렇게 작성할 수도 있다.
		return "service/scoreList";
	}
	
	//점수삭제 요청
	@RequestMapping("/scoreDelete")
	public String scoreDelete(@RequestParam("num") int num,
							  RedirectAttributes RA
			
			) {
		
		scoreService.scoreDelete(num);
		RA.addFlashAttribute("num", num); //번호를 리다이렉트 된 화면에 전달
		
		return "redirect:/service/scoreList";
	}
	
}
