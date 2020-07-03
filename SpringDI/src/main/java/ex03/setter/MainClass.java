package ex03.setter;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
//		DatabaseDev db = new DatabaseDev();
//		db.setUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
//		db.setUid("spring");
//		db.setUpw("spring");
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context.xml");
		DatabaseDev dbd = ctx.getBean(DatabaseDev.class);
		System.out.println(dbd.getUrl());
		System.out.println(dbd.getUid());
		System.out.println(dbd.getUpw());
		
		MemberDAO dao = ctx.getBean(MemberDAO.class);
		dao.info();
		
	}
}
