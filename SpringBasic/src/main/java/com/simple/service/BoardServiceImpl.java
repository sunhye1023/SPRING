package com.simple.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.command.BoardVO;
import com.simple.dao.BoardDAO;
import com.simple.mapper.BoardMapper;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

//	@Resource(name="boardDAO")
//	private BoardDAO boardDAO;
//	
//	@Override
//	public void boardRegist(BoardVO vo) {
//		
//		boardDAO.boardRegist(vo);
//		
//	}
//
//	@Override
//	public ArrayList<BoardVO> getList() {
//		
//		ArrayList<BoardVO> list = boardDAO.getList();
//		
//		return list;
//	}
//
//	@Override
//	public void boardDelete(int num) {
//		
//		boardDAO.boardDelete(num);
//		
//	}
	
	
	/*
	 * 1. Board관련 mybatis 인터페이스 선언, 구현체 생성.
	 * 2. xml파일에서는 아이디를 이용해서 mapper태그를 생성.
	 * 3. 서비스영역에서 mapper를 주입하고, 추상메서드를 실행.
	 */
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public void boardRegist(BoardVO vo) {
		
		//1st
		//boardMapper.boardRegist(vo);
		
		//2nd
		HashMap<String, String> map = new HashMap<>();
		map.put("name", vo.getName());
		map.put("title", vo.getTitle());
		map.put("content", vo.getContent());		
		
		boardMapper.boardRegist(map);
	
	}

	@Override
	public ArrayList<BoardVO> boardList() {
		
		return boardMapper.boardList();
	}

	@Override
	public void boardDelete(int num) {
		
		boardMapper.boardDelete(num);
		
	}


}
