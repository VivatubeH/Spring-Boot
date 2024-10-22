package di_1.none;

public class UserApp {

	public static void main(String[] args) {
		UserService service = new UserService();
		
		service.회원가입(new User(1, "홍길동", "hong@gmail.com"));
	}
}
