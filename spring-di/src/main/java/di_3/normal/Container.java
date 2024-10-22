package di_3.normal;

import java.util.HashMap;
import java.util.Map;

import di_2.loose.UserDaoMySQL;
import di_2.loose.UserDaoOracle;

public class Container { // 조립은 DI 

	Map<String, Object> box = new HashMap<String, Object>();
	
	// 애플리케이션 실행에 필요한 객체를 생성하고 조립하고 관리한다.
	public void createAndAssemble() {
		
		// 1. 애플리케이션 실행에 필요한 객체를 생성한다.
		UserDaoOracle oracle = new UserDaoOracle();
		UserDaoMySQL mysql = new UserDaoMySQL();
		UserService2 userService = new UserService2();
		
		// 2. 객체들간의 의존관계를 파악해서 객체를 조립한다.
		// 	  즉, UserService2 객체는 IUserDao 인터페이스의 구현객체가 필요하다.
		// 	  설정파일의 설정정보에 따라서 UserService2 객체에 
		// 	  UserDaoOracle 객체나 UserDaoMySQL 객체를 Setter 메소드를 실행해서 전달하자.
		userService.setUserDao(mysql);
		
		// 3. 조립이 완료된 객체를 보관한다.
		// oracle mysql userService
		box.put("oracleUserDao", oracle);
		box.put("mysqlUserDao", mysql);
		box.put("userService", userService);
	}
	
	// 지정된 key로 등록된 객체를 반환한다.
	public Object getBean(String key) {
		return box.get(key);
	}
}
