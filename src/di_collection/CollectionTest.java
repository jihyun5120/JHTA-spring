package di_collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionTest implements MyColl {
	List<String> list;
	Set<String> set;
	Map<String, String> map;
	Properties prop;
	
	@Override
	public void setList(List<String> list) {
		this.list = list;
		System.out.println("---List---");
		for(String str : list) {
			System.out.println(str);
		}
	}

	@Override
	public void setSet(Set<String> set) {
		this.set = set;
		System.out.println("---Set---");
		for(String str : set) {
			System.out.println(str);
		}
	}
	
	@Override
	public void setMap(Map<String, String> map) {
		this.map = map;
		Set<String> keys = map.keySet();
		System.out.println("---Map---");
		for(String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
	}

	@Override
	public void setProp(Properties prop) {
		this.prop = prop;
		Set<Object> keys = prop.keySet();
		System.out.println("---Prop---");
		for(Object key : keys) {
			System.out.println(key + " : " + prop.get(key));
		}
	}

	@Override
	public List<String> getList() {return list;}
	@Override
	public Set<String> getSet() {return set;}
	@Override
	public Map<String, String> getMap() {return map;}
	@Override
	public Properties getProp() {return prop;}
}
