package di_1.none;

public class UserApp {

	public static void main(String[] args) {
		
		UserService service = new UserService();
		
		// 회원가입 기능 실행하기
		service.회원가입(new User(10, "홍길동", "hong@gmail.com"));
	}
}
