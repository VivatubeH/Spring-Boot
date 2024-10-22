package di_2.loose;

import di_1.none.User;

public class UserApp {

	public static void main(String[] args) {
		
		UserService1 service = new UserService1();
		
		service.회원가입(new User());
		service.회원탈퇴(1);
		
	}
}
