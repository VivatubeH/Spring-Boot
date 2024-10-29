package di_8.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "di_8.javaconfig")
public class JavaConfig {

	@Bean
	public MyDao myDao() {
		return new MyDao();
	}
	
	@Bean
	public MyDao myDao(MyDao myDao) {
		MyService service = new MyService();
		service.setM
	}
}
