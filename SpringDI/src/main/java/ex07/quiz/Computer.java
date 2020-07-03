package ex07.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Computer {

	@Autowired
	@Qualifier("keyboard")
	private Keyboard kb;
	@Autowired
	@Qualifier("mouse")
	private Mouse mouse;
	@Autowired
	@Qualifier("monitor")
	private Monitor monitor;


	public void computerInfo() {
		System.out.println("***컴퓨터 정보***");
		kb.info();
		mouse.info();
		monitor.info();
	}
	
	
	
	
	
	
	
	
}
