package kr.co.jhta.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.jhta.mapper.UserMapper;
import kr.co.jhta.vo.User;

public class UserApp {

	public static void main(String[] args) {
		ApplicationContext ctx
			= new ClassPathXmlApplicationContext("context/context.xml");
		
		UserMapper userMapper = ctx.getBean(UserMapper.class);
		
//		User user = new User();
//		user.setId("kimbap33");
//		user.setPassword("zxcv1234");
//		user.setName("김밥왕");
//		user.setEmail("kingkimbap32@naver.com");
//		
//		userMapper.insertUser(user);
		User user1 = userMapper.getUserById("kimbap33");
		System.out.println(
				user1.getId() + ", " + user1.getPassword() + ", " + user1.getNo() + ", " + user1.getName() + ", " + user1.getEmail() 
				);
		
		User user2 = userMapper.getUserByNo(2);
		System.out.println(
				user2.getId() + ", " + user2.getPassword() + ", " + user2.getNo() + ", " + user2.getName() + ", " + user2.getEmail() 
				);
		
		List<User> user3 = userMapper.getUsersByName("이상현");
		
		List<User> users = userMapper.getAllUsers();
		for(User user : users) {
			System.out.println(user.getId() + ", " + user.getPassword() + ", " + user.getNo() + ", " + user.getName() + ", " + user.getEmail());
		}
		
		System.out.println();
	}
}
