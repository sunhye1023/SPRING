package com.simple.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import com.simple.command.BoardVO;

public interface BoardMapper {

	//1st
	//public void boardRegist(BoardVO vo);
	//2nd
	public void boardRegist(HashMap<String, String> map);
	
	public ArrayList<BoardVO> boardList();
	public void boardDelete(int num);
	
}
