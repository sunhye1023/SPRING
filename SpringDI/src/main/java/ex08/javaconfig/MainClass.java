package ex08.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ex01.SpringTest;
import ex03.setter.DatabaseDev;

public class MainClass {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		SpringTest st = ctx.getBean(SpringTest.class);
		st.test();
		
		DatabaseDev dev = ctx.getBean(DatabaseDev.class);
		System.out.println(dev.getUrl());
		System.out.println(dev.getUid());
		System.out.println(dev.getUpw());
		
	}
}


