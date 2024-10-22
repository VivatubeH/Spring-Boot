package di_3.normal;

import java.util.HashMap;
import java.util.Map;

import di_2.loose.UserDaoMySQL;
import di_2.loose.UserDaoOracle;

public class Container {

	Map<String, Object> map = new HashMap<>();
	
	public void createAndAssemble() {
		// 애플리케이션에 필요한 객체들 생성
		UserDaoMySQL mysql = new UserDaoMySQL();
		UserDaoOracle oracle = new UserDaoOracle();
		UserService2 service = new UserService2();
		
		// 스프링 빈 설정파일에 맞게 setter 메서드에 넣어준다.
		service.setUserDao(oracle);
		
		map.put("mysqlUserDao", mysql);
		map.put("oracleUserDao", oracle);
		map.put("service", service);
	}
	
	public Object getBeans(String key) {
		return map.get(key);
	}
}	

