package aop_step2_1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Advisor {
	Dao dao;
	SimpleDateFormat logTime = new SimpleDateFormat("yyyy-MM-dd(E요일) hh:ss:SS");
	
	public void before() {
		System.out.println(logTime.format(new Date()));
		dao.insert();
	}
	
	public void after() {
		dao.select();
		System.out.println(logTime.format(new Date()));
	}
	
	public void around() {
		System.out.println(logTime.format(new Date()));
		dao.modify();
		System.out.println(logTime.format(new Date()));
	}

	public Dao getDao() {return dao;}

	public void setDao(Dao dao) {this.dao = dao;}
}
