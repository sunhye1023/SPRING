package com.simple.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.dao.ScoreDAO;
import com.simple.mapper.ScoreMapper;

//@Service("빈의 아이디") - 기술하지 않으면 마음대로 이름을 만들어서 집어넣는다(자동빈생성)
@Service("scoreService") //component-scan이 읽어서 scoreService이름으로 
public class ScoreServiceImpl implements ScoreService {

//	@Resource(name="scoreDAO")
//	private ScoreDAO scoreDAO;
//	
//	@Override
//	public void scoreRegist(ScoreVO vo) {
//	
//		scoreDAO.scoreRegist(vo);
//	
//	}
//
//	@Override
//	public ArrayList<ScoreVO> scoreList() {
//		
//		ArrayList<ScoreVO> list = scoreDAO.scoreList();
//		
//		return list;
//	}
//
//	@Override
//	public void scoreDelete(int num) {
//		
//		scoreDAO.scoreDelete(num);
//		
//	}

	
	@Autowired
	private ScoreMapper scoreMapper;
	
	@Override
	public void scoreRegist(ScoreVO vo) {
		
		int result = scoreMapper.scoreRegist(vo);
		System.out.println("Regist성공실패: " + result);
		
	}
	
	@Override
	public ArrayList<ScoreVO> scoreList() {
		
		return scoreMapper.scoreList();
	
	}
	
	@Override
	public void scoreDelete(int num) {
		
		scoreMapper.scoreDelete(num);
		
	}
	
}
