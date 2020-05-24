package aop_aspectj;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;

public class Advisor{
	SimpleDateFormat logTime = new SimpleDateFormat("yyyy-MM-dd(E요일) hh:ss:SS");
	
	public Object beforeMethod(JoinPoint point) { //무조건 반환형은 Object타입으로.
		System.out.println(logTime.format(new Date()));
		return null;
	}
}




