package aop.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext ctx 
			= new ClassPathXmlApplicationContext("context/demo1.xml");
		
		UserService service = ctx.getBean(UserService.class);
		BookService service2 = ctx.getBean(BookService.class);
		
		service.addUser("hong", "홍길동", "zxcv1234");
		service.deleteUser("kang");
		
		service2.getTotalRows("it/컴퓨터", "자바");
		service2.addCart(100, 3, "kim");
	}
}
