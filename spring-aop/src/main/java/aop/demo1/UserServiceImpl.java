package aop.demo1;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService { // 공통 기능이 적용될 대상 ( target ) 

	public void addUser(String id, String name, String pwd) { // JoinPoint
		try {
			System.out.println("핵심기능: 신규 사용자를 등록한다.");
			Thread.sleep(1000);			
		} catch (Exception e) {}
	}
	
	public void deleteUser(String id) { // JoinPoint		
		try {
			System.out.println("핵심기능: 사용자를 삭제합니다.");
			Thread.sleep(3000);			
		} catch (Exception e) {}
	}
}
