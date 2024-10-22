package di_1.none;

public class UserDao {

	public void insertUser(User user) {
		System.out.println("UserDao의 insertUser() 실행됨");
		System.out.println(user.getNo() + ", " + user.getName() + ", " + user.getEmail());
	}
	
	public void deleteUser(int no) {
		System.out.println("UserDao의 deleteUser() 실행됨");
		System.out.println(no);
	}
}
