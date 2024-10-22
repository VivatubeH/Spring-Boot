package di_4.spring;

public class NotificationService {

	/*
	 * NotificationService
	 * 	- MessageSender 인터페이스에 의존한다.
	 *  - 알림메세지를 보내기 위해서는 MessageSender 인터페이스를 구현한
	 *    구현객체가 필요하다. ( 의존한다. )
	 *    
	 *  1. MessageSender 구현객체를 참조하는 참조변수가 필요하다.
	 *  2. MessageSender 구현객체를 외부로부터 제공받기 위한 Setter 메소드가 필요하다.
	 */
	private MessageSender messageSender;
	
	// 주입 받을 준비가 완료된 상태.
	public void setMessageSender(MessageSender messageSender) {
		System.out.println("setMessageSender() 메소드 실행됨");
		System.out.println("setMessageSender() 메소드 실행시 주입된 객체: " + messageSender);
		this.messageSender = messageSender;
	}
	
	public NotificationService() {
		System.out.println("NotificationService() 생성자 메소드 실행됨");
	}
	
	public NotificationService(MessageSender messageSender) {
		System.out.println("NotificationService(MessageSender) 생성자 메소드 실행됨");
		System.out.println("NotificationService(MessageSender) 메소드 실행시 주입된 객체: " + messageSender);
		this.messageSender = messageSender;
	}

	public void notice(String from, String to, String title, String content) {
		System.out.println("NotificationService의 notice() 실행됨");
		
		messageSender.send(from, to, title, content);
	}
}
