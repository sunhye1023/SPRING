package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
//		SpringTest st = new SpringTest();
//		st.test();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context.xml");
		
		SpringTest st1 = ctx.getBean(SpringTest.class);
		st1.test();
		
		SpringTest st2 = ctx.getBean(SpringTest.class);
		st2.test();
		
		//스프링IOC컨테이너는 기본적으로 bean을 싱글톤 형식을 생성합니다.
		//만약, bean을 사용할 때마다 새로운 객체 형태로 쓰고싶다면 scope="prototype"을 기술하면 됩니다.
		System.out.println(st1);
		System.out.println(st2);
		
	}
}
