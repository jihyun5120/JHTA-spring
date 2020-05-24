package di_autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DiAutowireMain {
	
	public DiAutowireMain() {
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/di_autowire/autowire_name.xml");
		ByNameDao dao = (ByNameDao)ac.getBean("dao");
		
		ByTypeDao dao2 = (ByTypeDao)ac.getBean("dao2");
		
	}
	
	public static void main(String[] args) {
		new DiAutowireMain();
	}
}
