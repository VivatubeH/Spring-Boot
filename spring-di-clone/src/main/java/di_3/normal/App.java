package di_3.normal;

import di_1.none.User;

public class App {

	public static void main(String[] args) {
		// Container 객체를 생성
		Container container = new Container();
		// 객체를 생성하고 조립한다. 빈 설정파일에 맞게
		container.createAndAssemble();
		// 객체를 얻어온다.
		UserService2 service = (UserService2) container.getBeans("service");
		
		service.회원가입(new User(1, "김탁구", "mrpingpong@naver,com"));
	}
}
