package di_5.scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// 스프링 컨테이너에서 객체 생성하기 [ 설정 정보 주입 ]
		ApplicationContext ctx
			= new ClassPathXmlApplicationContext("context/di-5.xml");
		
		// 필요한 객체 꺼내기
		BoardService service = ctx.getBean(BoardService.class);
		
		// 객체의 메서드 사용하기
		service.게시글등록("이 글 좀 봐주세요", "봤으면 됐어요");
	}
}
