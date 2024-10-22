package di_2.loose;

import di_1.none.User;

public class UserDaoOracle implements IUserDao {

	public void insertUser(User user) {
		System.out.println("UserDaoOracle의 insertUser() 실행됨");
	}
	
	public void deleteUser(int no) {
		System.out.println("UserDaoOracle의 deleteUser() 실행됨");
	}
}
