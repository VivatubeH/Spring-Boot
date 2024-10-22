package di_8.javaconfig;

public class MyService {

	private MyDao myDao;
	
	public void setMyDao(MyDao myDao) {
		this.myDao = myDao;
		System.out.println("MyService객체의 setMyDao() 메소드 실행됨");
		System.out.println("MyService객체의 setMyDao() 메소드에 전달된 객체: " + myDao);
	}
	
	public MyService() {
		System.out.println("MyService객체의 생성자 메소드 실행됨");
	}
}
