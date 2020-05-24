package aop_step3;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Advisor implements MethodInterceptor{
	Dao dao;
	SimpleDateFormat logTime = new SimpleDateFormat("yyyy-MM-dd(E요일) hh:ss:SS");
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		//횡단적 관심사로 분리된 처리 내용
		System.out.println(logTime.format(new Date()));
		Object o = invocation.proceed(); //proxy에 의해서 호출된 value에 있는 메소드를 실행시켜줌.
		System.out.println(logTime.format(new Date()));
		
		return o;
	}
}




