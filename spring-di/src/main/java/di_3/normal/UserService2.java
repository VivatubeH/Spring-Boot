package di_3.normal;

import di_1.none.User;
import di_2.loose.IUserDao;

public class UserService2 {

	/*
	 * UserService2는 IUserDao 인터페이스에 의존한다.
	 * - UserService2는 자신이 의존하는 객체를 직접 획득(생성)하지 않는다.
	 * - UserService2는 자신이 의존하는 객체를 제 3자로부터 제공받는다.
	 * 
	 * 1. 자신의 의존하는 객체를 참조하는 참조변수를 정의한다.
	 * 2. 제 3자로부터 객체를 제공받기 위한 메소드를 정의한다.
	 * 	* Setter 메소드, 생성자 메소드를 이용해서 제 3자가 객체를 전달하도록 한다.
	 */
	
	// UserService2는 자신의 의존하는 객체를 직접 생성하지 않고
	// 의존하는 객체를 참조하는 참조변수만 정의한다.
	// 이 참조변수는 의존하는 객체와 연결될 연결잭이다.
	private IUserDao userDao;
	
	// UserService2는 자신의 의존하는 객체를 직접 생성하지 않기 때문에
	// 제 3자가 객체를 전달해 줄 수 있는 메소드를 정의한다.
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	public void 회원가입(User user) {
		System.out.println("UserService2 객체의 회원가입() 실행됨");
		userDao.insertUser(user);
	}
	
	public void 회원탈퇴(int no) {
		System.out.println("UserService2 객체의 회원탈퇴() 실행됨");
		userDao.deleteUser(no);
	}
}
