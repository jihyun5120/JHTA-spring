package aop_anno;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Advisor{
	SimpleDateFormat logTime = new SimpleDateFormat("yyyy-MM-dd(E요일) hh:ss:SS");
	
	@Before("execution(* aop_anno.Dao.*(..))") //aop_anno패키지에 Dao클래스 안에 있는 모든 메소드(매개변수)
	public Object beforeMethod(JoinPoint point) { //무조건 반환형은 Object타입으로.
		System.out.println(logTime.format(new Date()));
		return null;
	}
	
	@Around("execution(* modify(..))") //around타입만 형태가 다름.
	public Object aroundMethod(ProceedingJoinPoint point) {
		try {
			System.out.println(logTime.format(new Date()));
			point.proceed();
			System.out.println(logTime.format(new Date()));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
}




