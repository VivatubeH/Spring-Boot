package di_1.none;

public class UserService {
	
	UserDao2 userDao2 = new UserDao2();
	
	public void 회원가입(User user) {
		System.out.println("userService의 회원가입() 메서드 실행됨");
		userDao2.addUser(user);
	}
	
	public void 회원탈퇴(int no) {
		System.out.println("userService의 회원탈퇴() 메서드 실행됨");
		userDao2.removeUser(no);
	}
}

