package ex06.autowired;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("autowired-context.xml");
		
		//autowired 확인
		Printer p = ctx.getBean(Printer.class);
		System.out.println("autowired 확인: "+p.getDocument().data);
		
		//resource확인
		/*
		 * Printer2 p2 = ctx.getBean(Printer2.class);
		 * System.out.println("resource확인: "+p2.getDocument().data);
		 */
		
	}
}
