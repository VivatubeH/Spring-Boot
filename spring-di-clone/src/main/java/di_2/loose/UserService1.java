package di_2.loose;

import di_1.none.User;

public class UserService1 {

	IUserDao userDao1 = new UserDaoMySQL();
	IUserDao userDao2 = new UserDaoOracle();
	
	public void 회원가입(User user) {
		System.out.println("UserService1의 회원가입() 실행됨");
		userDao2.insertUser(user);
	}
	
	public void 회원탈퇴(int no) {
		System.out.println("UserService1의 회원가입() 실행됨");
		userDao2.deleteUser(no);
	}
}
