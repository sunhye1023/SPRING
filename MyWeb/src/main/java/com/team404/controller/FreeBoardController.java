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
	public String freeList(Model model) {

		//기본
		ArrayList<FreeBoardVO> list = freeBoardService.getList();
		model.addAttribute("boardList", list);

		return "freeBoard/freeList";
	}

	//등록화면
	@RequestMapping("/freeRegist")
	public String freeRegist() {

		return "freeBoard/freeRegist";
	}

	//수정화면
	@RequestMapping("/freeModify")
	public String freeModify(@RequestParam("bno") int bno, Model model) {

		model.addAttribute("vo", freeBoardService.getModify(bno));

		return "freeBoard/freeModify";
	}

	//업데이트
	@RequestMapping("/freeUpdate")
	public String freeUpdate(FreeBoardVO vo, RedirectAttributes RA) {

		int updateResult = freeBoardService.update(vo);

		if(updateResult==1) {
			System.out.println(updateResult);
			RA.addFlashAttribute("msg", "게시글 수정이 정상 처리되었습니다");
			return "redirect:/freeBoard/freeList";
		} else {
			RA.addFlashAttribute("msg", "게시글 수정을 실패했습니다");
			return "redirect:/freeBoard/freeModify";
		}

	}

	//삭제
	@RequestMapping("/freeDelete")
	public String freeDelete(@RequestParam("bno") int bno, RedirectAttributes RA) {
		
		int deleteResult = freeBoardService.delete(bno);

		if(deleteResult==1) {
			System.out.println(deleteResult);
			RA.addFlashAttribute("msg", "게시글을 삭제했습니다");
			return "redirect:/freeBoard/freeList";
		} else {
			RA.addFlashAttribute("msg", "게시글을 삭제하는데 실패했습니다");
			return "redirect:/freeBoard/freeModify";
		}

	}

	//상세화면
	@RequestMapping("/freeDetail")
	public String freeDetail(@RequestParam("bno") int bno, Model model) {

		model.addAttribute("vo", freeBoardService.getContent(bno));
		System.out.println(bno);

		return "freeBoard/freeDetail";
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



}
