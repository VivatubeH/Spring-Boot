package di_4.spring;

public class NotificationService {

	// 의존하는 참조변수를 선언해준다.
	private MessageSender messageSender;

	public NotificationService() {
		System.out.println("NotificationService의 기본 생성자 메소드 실행됨");
	}
	
	public NotificationService(MessageSender sender) {
		System.out.println("NotificationSErvice의 매개변수 1개 생성자 메소드 실행됨");
		System.out.println("전달된 매개변수: " + sender);
	}
	// Setter 메서드를 통해 의존하는 객체를 주입받을 준비완료.
	public void setMessageSender(MessageSender messageSender) {
		System.out.println("NotificationService의 setMessageSender() 메서드 실행됨");
		System.out.println("NotificationService의 setMessageSender() 메서드를 통해 얻은 객체 :" + messageSender);
		this.messageSender = messageSender;
	}
	
	// NotificationService의 notice() 메서드 실행. 
	public void notice(String from, String to, String title, String content) {
		System.out.println("NotificationService의 notice() 메서드 실행됨");
		messageSender.send(from, to, title, content);
	}

}
