package com.team404.freeboard.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.FreeBoardVO;
import com.team404.freeboard.mapper.FreeBoardMapper;

@Service("freeBoardService")
public class FreeBoardServiceImpl implements FreeBoardService {

	@Autowired
	private FreeBoardMapper freeBoardMapper;
	
	@Override
	public void regist(FreeBoardVO vo) {
		
		freeBoardMapper.regist(vo);
	}

	@Override
	public ArrayList<FreeBoardVO> getList() {
		
		return freeBoardMapper.getList();
	}

	@Override
	public FreeBoardVO getContent(int bno) {
		
		return freeBoardMapper.getContent(bno);
		
	}

	@Override
	public FreeBoardVO getModify(int bno) {
		
		return freeBoardMapper.getModify(bno);
		
	}

	@Override
	public int update(FreeBoardVO vo) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		vo.setUpdatedate(Timestamp.valueOf(sdf.format(date)));		
		return freeBoardMapper.update(vo);

	}

	@Override
	public int delete(int bno) {
		
		return freeBoardMapper.delete(bno);
	}

	

	

}
