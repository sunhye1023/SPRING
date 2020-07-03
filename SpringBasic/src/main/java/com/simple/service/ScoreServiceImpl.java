package com.simple.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.dao.ScoreDAO;

//@Service("빈의 아이디") - 기술하지 않으면 마음대로 이름을 만들어서 집어넣는다(자동빈생성)
@Service("scoreService") //component-scan이 읽어서 scoreService이름으로 
public class ScoreServiceImpl implements ScoreService {

	@Resource(name="scoreDAO")
	private ScoreDAO scoreDAO;
	
	@Override
	public void scoreRegist(ScoreVO vo) {
	
		scoreDAO.scoreRegist(vo);
	
	}

	@Override
	public ArrayList<ScoreVO> scoreList() {
		
		ArrayList<ScoreVO> list = scoreDAO.scoreList();
		
		return list;
	}

	@Override
	public void scoreDelete(int num) {
		
		scoreDAO.scoreDelete(num);
		
	}

	
	
}
