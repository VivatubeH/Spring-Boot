package di_4.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		// 스프링 컨테이너를 생성한다.
		/*
		 * 사용한 스프링 컨테이너
		 * 		ClassPathXmlApplicationContext
		 * 
		 * 설정파일의 경로와 파일명
		 * 		"context/di-4.xml"
		 * 
		 * 아래의 수행문이 실행되면
		 * 	- SmsMessageSender 객체가 생성된다.
		 *  - KakaoTalkMessageSender 객체가 생성된다.
		 *  - NotificationService 객체가 생성된다.
		 *  - NotificationService 객체의 멤버변수에 SmsMessageSender객체나
		 *    KakaoTalkMessageSender 객체 중 하나가 의존성 주입된다.
		 */
		ApplicationContext ctx 
			= new ClassPathXmlApplicationContext("context/di-4.xml");
		
		// 스프링 컨테이너에서 필요한 객체를 꺼낸다.
		/*
		 * Object getBean(String beanName)
		 * T getBean(Class T)
		 * T getBean(String beanName, class T)
		 */
		NotificationService x 
			= (NotificationService) ctx.getBean("service1");
		
		// .class = 클래스 객체 반환, 따로 형변환을 적을 필요 없음. 
		NotificationService y
			= ctx.getBean("service2", NotificationService.class);
		
		// 객체를 사용한다.
		x.notice("010-1111-1111", "010-2222-2222", "결재요청", "긴급 결재 바랍니다.");
		y.notice("홍길동 사원", "나쁜 사장", "월급줘", "나쁜 놈아 월급줘");
	}
}
