package di_4.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		// 스프링 컨테이너 생성
		// ClassPathXmlApplicationContext라는 스프링 컨테이너를 사용했다.
		ApplicationContext ctx 
			= new ClassPathXmlApplicationContext("context/di-4.xml");
		
		// 컨테이너를 통해 생성된 객체를 사용하기 위해 얻어와야 함.
		NotificationService service = ctx.getBean("service2", NotificationService.class);
		
		service.notice("김탁구", "홍길동", "안녕하세요", "취업시켜주세요.");
	}
}
