package com.team404.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team404.command.FreeBoardVO;
import com.team404.freeboard.service.FreeBoardService;
import com.team404.util.Criteria;
import com.team404.util.PageVO;

@Controller
@RequestMapping("freeBoard")
public class FreeBoardController {

	/*
	 * 화면처리 -> 테이블생성 -> 등록처리
	 */

	@Autowired
	@Qualifier("freeBoardService")
	private FreeBoardService freeBoardService;

	//목록화면
	@RequestMapping("/freeList")
	public String freeList(Model model, Criteria cri) {

		//기본
		//ArrayList<FreeBoardVO> list = freeBoardService.getList();
		//model.addAttribute("boardList", list);
		//System.out.println(list.toString());

		//페이징
		//ArrayList<FreeBoardVO> list = freeBoardService.getList(cri); //페이지 계산 처리
		//System.out.println(cri.toString());
		//int total = freeBoardService.getTotal(); //총 게시글 수
		//PageVO pageVO = new PageVO(cri, total); //화면에 그려질 페이지네이션처리
		
		//검색페이징
		ArrayList<FreeBoardVO> list = freeBoardService.getList(cri);
		int total = freeBoardService.getTotal(cri);
		PageVO pageVO = new PageVO(cri, total);
		
		//System.out.println(cri.toString());
		System.out.println("list : "+list.toString());
		System.out.println("total : "+total);
		
		model.addAttribute("boardList", list);
		model.addAttribute("pageVO", pageVO);
		
		
		
		return "freeBoard/freeList";
	}

	//등록화면
	@RequestMapping("/freeRegist")
	public String freeRegist() {

		return "freeBoard/freeRegist";
	}
	
	//등록처리
	@RequestMapping(value="/registForm", method=RequestMethod.POST)
	public String registForm(FreeBoardVO vo, RedirectAttributes RA) {
		
		//System.out.println(vo.toString());
		freeBoardService.regist(vo);
		
		//등록성공여부(msg) - 1회성 사용 가능
		RA.addFlashAttribute("msg", "정상등록처리되었습니다");
		
		return "redirect:/freeBoard/freeList"; //등록후에 리스트화면으로 리다이렉트
	}

//	//상세화면
//	@RequestMapping("/freeDetail")
//	public String freeDetail(@RequestParam("bno") int bno, Model model) {
//		
//		model.addAttribute("vo", freeBoardService.getContent(bno));
//		System.out.println(bno);
//		
//		return "freeBoard/freeDetail";
//	}
//	
//	//수정화면
//	@RequestMapping("/freeModify")
//	public String freeModify(@RequestParam("bno") int bno, Model model) {
//
//		model.addAttribute("vo", freeBoardService.getContent(bno));
//
//		return "freeBoard/freeModify";
//	}

	//상세화면과 수정화면의 코드가 같기 때문에 묶어서 써도 된다
	@RequestMapping({"/freeDetail", "/freeModify"})
	public void freeModify(@RequestParam("bno") int bno, Model model) {

		model.addAttribute("vo", freeBoardService.getContent(bno));

	}
	
	
	//업데이트
	@RequestMapping("/freeUpdate")
	public String freeUpdate(FreeBoardVO vo, RedirectAttributes RA) {

		int updateResult = freeBoardService.getUpdate(vo);

		if(updateResult==1) {
			System.out.println(updateResult);
			RA.addFlashAttribute("msg", "게시글 수정이 정상 처리되었습니다");
		} else {
			RA.addFlashAttribute("msg", "게시글 수정에 실패했습니다");
		}

		return "redirect:/freeBoard/freeList";
	}

	//삭제
	@RequestMapping("/freeDelete")
	public String freeDelete(@RequestParam("bno") int bno, RedirectAttributes RA) {
		
		int deleteResult = freeBoardService.getDelete(bno);

		if(deleteResult==1) {
			System.out.println(deleteResult);
			RA.addFlashAttribute("msg", "게시글을 삭제했습니다");
		} else {
			RA.addFlashAttribute("msg", "게시글을 삭제하는데 실패했습니다");
		}
		return "redirect:/freeBoard/freeList";

	}




}
