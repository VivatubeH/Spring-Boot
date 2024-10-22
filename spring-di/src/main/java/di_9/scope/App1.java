package di_9.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App1 {

	public static void main(String[] args) {
		ApplicationContext ctx 
			= new AnnotationConfigApplicationContext(JavaConfig.class);
		
		// Singleton -> 같은 객체만 계속 내놓음.
		// prototype -> 쓸 때 마다 다른 객체를 내놓음.
		SampleDao dao1 = ctx.getBean(SampleDao.class);
		SampleDao dao2 = ctx.getBean(SampleDao.class);
		SampleDao dao3 = ctx.getBean(SampleDao.class);
		SampleDao dao4 = ctx.getBean(SampleDao.class);
		SampleDao dao5 = ctx.getBean(SampleDao.class);
		
		System.out.println("dao1: " + dao1);
		System.out.println("dao2: " + dao2);
		System.out.println("dao3: " + dao3);
		System.out.println("dao4: " + dao4);
		System.out.println("dao5: " + dao5);
	}
}
