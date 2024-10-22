package di_8.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "di_8.javaconfig")
public class JavaConfig { // xml을 대체하기 위해 등장함.

	// 매개변수 없는 것부터 실행해서 객체를 만들고,
	@Bean
	public MyDao myDao() {
		return new MyDao();
	}
	
	// 매개변수 있는 거에 객체가 필요하면 자기가 만든 객체를 주입해준다.
	@Bean
	public MyService myService(MyDao myDao) { // 주입받아야 할 객체를 적는다.
		// 조립은 수동으로 해야함
		MyService service = new MyService();
		service.setMyDao(myDao);
		
		return new MyService();
	}
	
	@Bean
	public MeService meService(MyDao myDao) {
		MeService meService = new MeService();
		meService.setMyDao(myDao);
		
		return meService;
	}
}
