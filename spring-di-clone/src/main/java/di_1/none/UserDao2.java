package di_1.none;

public class UserDao2 {

	public void addUser(User user) {
		System.out.println("UserDao2의 addUser() 실행됨");
		System.out.println(user.getNo() + ", " + user.getName() + ", " + user.getEmail());
	}
	
	public void removeUser(int no) {
		System.out.println("UserDao2의 removeUser() 실행됨");
		System.out.println(no);
	}
}
