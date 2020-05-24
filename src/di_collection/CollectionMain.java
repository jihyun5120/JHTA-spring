package di_collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class CollectionMain {
	
	public CollectionMain() {
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/di_collection/collection.xml");
		CollectionTest ct =  (CollectionTest)ac.getBean("coll"); //한번에 쫙!
		
		//list
		/* getter썼을 때 사용하는 방법(setter에 기술안하고 여기 기술.)
		MyColl mc = (MyColl)ac.getBean("coll"); //인터페이스에 모든 내용이 기술되어있을 떼는 사용가능.
		List<String> list = mc.getList();
		System.out.println("---List---");
		for(String str : list) {
			System.out.println(str);
		}*/
		
		//set
		/*Set<String> set =  mc.getSet();
		System.out.println("---Set---");
		for(String str : set) {
			System.out.println(str);
		}*/
		
		//map
		/*Map<String, String> map = mc.getMap();
		Set<String> keys = map.keySet();
		System.out.println("---Map---");
		for(String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}*/
		
		//prop
		/*Properties prop = mc.getProp();
		Set<Object> keys = prop.keySet();
		System.out.println("---Prop---");
		for(Object key : keys) {
			System.out.println(key + " : " + prop.get(key));
		}*/
	}
	
	public static void main(String[] args) {
		new CollectionMain();
	}
}
