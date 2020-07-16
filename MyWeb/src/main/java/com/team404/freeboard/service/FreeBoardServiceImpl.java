package com.team404.freeboard.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.FreeBoardVO;
import com.team404.freeboard.mapper.FreeBoardMapper;
import com.team404.util.Criteria;

@Service("freeBoardService")
public class FreeBoardServiceImpl implements FreeBoardService {

	@Autowired
	private FreeBoardMapper freeBoardMapper;
	
	@Override
	public void regist(FreeBoardVO vo) {
		
		freeBoardMapper.regist(vo);
	}

	@Override
	public ArrayList<FreeBoardVO> getList(Criteria cri) {
		
		return freeBoardMapper.getList(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		
		return freeBoardMapper.getTotal(cri);
	}

	@Override
	public FreeBoardVO getContent(int bno) {
		
		return freeBoardMapper.getContent(bno);
		
	}

	@Override
	public int getUpdate(FreeBoardVO vo) {
		
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		vo.setUpdatedate(Timestamp.valueOf(sdf.format(date)));		
		
		return freeBoardMapper.getUpdate(vo);

	}

	@Override
	public int getDelete(int bno) {
		
		return freeBoardMapper.getDelete(bno);
	
	}

	

	

}
