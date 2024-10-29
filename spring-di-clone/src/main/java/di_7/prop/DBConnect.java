package di_7.prop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DBConnect {

	@Value("${db.url}")
	private String url;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	
	public void config() {
		System.out.println("url은 " + url);
		System.out.println("username은 " + username);
		System.out.println("password는 " + password);
	}
}
