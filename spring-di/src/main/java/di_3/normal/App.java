package di_3.normal;

import di_1.none.User;

public class App {

	public static void main(String[] args) {
		
		// 1. 객체를 생성하고 조립하는 컨테이너 생성하기 
		Container container = new Container();
		// 2. 컨테이너의 객체 생성/조립기능 실행하기
		container.createAndAssemble();
		
		// 3. 컨테이너에서 필요한 객체를 꺼내온다. [ DL : 컨테이너가 만들어놓은 것 중 하나를 꺼내오는 것 ]
		UserService2 service = (UserService2) container.getBean("userService");
		
		// 4. 애플리케이션 실행하기
		service.회원가입(new User(1, "김유신", "kim@gmail.com"));
	}
}
