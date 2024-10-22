package di_3.normal;

import di_1.none.User;
import di_2.loose.IUserDao;

public class UserService2 {

	// 참조변수 선언만 하고,
	IUserDao userDao;
	
	// 외부로부터 얻어오기 위해 Setter 메서드 사용
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	public void 회원가입(User user) {
		System.out.println("UserService2의 회원가입() 실행됨");
		userDao.insertUser(user);
	}
	
	public void 회원탈퇴(int no) {
		System.out.println("UserService2의 회원탈퇴() 실행됨");
		userDao.deleteUser(no);
	}
}
