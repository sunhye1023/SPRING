package ex07.quiz;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Computer {

//	@Autowired
//	@Qualifier("keyboard")
	@Resource(name="keyboard")
	private Keyboard kb;
//	@Autowired
//	@Qualifier("mouse")
	@Resource(name="mouse")
	private Mouse mouse;
//	@Autowired
//	@Qualifier("monitor")
	@Resource(name="monitor")
	private Monitor monitor;


	public void computerInfo() {
		System.out.println("***컴퓨터 정보***");
		kb.info();
		mouse.info();
		monitor.info();
	}
	
	
	
	
	
	
	
	
}
