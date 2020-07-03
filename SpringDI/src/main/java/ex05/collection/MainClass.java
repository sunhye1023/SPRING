package ex05.collection;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("collection-context.xml");
		Customer c = ctx.getBean(Customer.class);
		System.out.println(c.getLists());
		System.out.println(c.getVo());
		System.out.println(c.getMaps());
	
	}
}
