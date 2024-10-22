package di_5.scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		// 스프링 컨테이너 객체 생성하기
		ApplicationContext ctx
			= new ClassPathXmlApplicationContext("context/di-5.xml");
		
		// 스프링 컨테이너에서 사용할 객체 꺼내기
		BoardService service = ctx.getBean(BoardService.class);
		
		// 객체 사용하기
		service.게시글등록("연습", "연습입니다.");
	}
}
