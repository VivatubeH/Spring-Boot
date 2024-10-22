package di_6.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		// ApplicationContext는 모든 스프링 컨테이너의 부모
		ApplicationContext ctx
			= new ClassPathXmlApplicationContext("context/di-6.xml");
		
		
	}
}
