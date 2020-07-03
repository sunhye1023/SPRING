package com.simple.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;

//@Component //일반 빈 의미
//@Service("scoreDAO") //서비스영역
@Repository("scoreDAO")	//DAO영역
public class ScoreDAOImpl implements ScoreDAO {

	//DB라고 가정
	private ArrayList<ScoreVO> DB = new ArrayList<>();
	
	@Override
	public void scoreRegist(ScoreVO vo) {
		
		DB.add(vo); //화면에서 전달한 값이 출력
		System.out.println(DB.toString());
		//System.out.println("scoreDAO영역");
		
	}

	@Override
	public ArrayList<ScoreVO> scoreList() {
		
		
		
		return DB;
	}

	@Override
	public void scoreDelete(int num) {
		
		DB.remove(num);
		
	}

}
