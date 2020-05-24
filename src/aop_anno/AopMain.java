package aop_anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AopMain {
	
	public AopMain() {
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/aop_anno/aop.xml");
		Dao dao = (Dao)ac.getBean("member");
		dao.delete();
		dao.select();
		dao.modify();
		dao.insert();
	}
	
	public static void main(String[] args) {
		new AopMain();
	}
}



