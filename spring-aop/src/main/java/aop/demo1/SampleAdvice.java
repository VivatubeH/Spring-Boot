package aop.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import java.lang.Throwable;

@Aspect
@Component
public class SampleAdvice {

	@Pointcut("execution(* aop.demo1.*ServiceImpl.*(..))")
	private void myPointcut() {}
	
	// when을 결정 [ @Before ], where을 결정 [ () 괄호안에 적음, within(대상 클래스) ]
	@Before("myPointcut()")  
	public void logging(JoinPoint joinPoint) { // what
		// 공통기능이 적용된 대상 메소드의 이름을 출력하기
		String methodName = joinPoint.getSignature().getName();
		System.out.println("실행된 메소드: " + methodName);
		
		// 공통기능이 적용된 대상 메소드의 매개변수값 출력하기
		Object[] args = joinPoint.getArgs();
		System.out.println("매개변수: ");
		if (args.length > 0) {
			for (Object arg : args) {
				System.out.println(" - " + arg);
			}
		} else {
			System.out.println(" - 없음");
		}
	}
		
	@Around("myPointcut()")
	public Object runningTimeCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
			
		System.out.println("Around Advice: 대상 메소드를 실행 전 코드 실행");
		long startTime = System.currentTimeMillis();
		
		Object returnValue = joinPoint.proceed(); // 대상 메소드 실행
		
		System.out.println("Around Advice: 대상 메소드를 실행 후 코드 실행");
		long endTime = System.currentTimeMillis();
		
		long runningTime = endTime - startTime;
		System.out.println("실행소요시간: " + runningTime + " 밀리초");
		
		return returnValue;
	}
}
