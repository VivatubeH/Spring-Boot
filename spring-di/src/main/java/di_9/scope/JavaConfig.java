package di_9.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaConfig {
	
	@Bean
	/*
	 * 스프링 빈의 스코프
	 *   + 빈의 스코프는 스프링 컨테이너가 생성한 빈의 유효 범위를 말한다.
	 *   + 빈의 유효범위는 5가지가 있다.
	 *   + 빈의 기본 유효범위는 "singleton" 이다.
	 *   + 유효범위의 종류
	 *   	- singleton
	 *    		+ 스프링 빈의 기본 유효범위다.
	 *          + 스프링 컨테이너내에 오직 하나의 객체만 존재한다.
	 *          + 스프링 컨테이너가 객체의 라이프사이클을 관리한다.
	 *      - prototype
	 *          + 스프링 컨테이너에 객체를 요청할 때마다 매번 새로 생성한다.
	 *          + 스프링 컨테이너가 객체의 라이프사이클을 관리하지 않는다.
	 *            생성한 다음 방치한다.
	 *      - request, session, application
	 *      	+ 위의 3가지 스코프는 웹 기반 애플리케이션에서만 지원되는 스코프이다.
	 * 	@scope("prototype")
	 *  @scope("singleton")
	 */
	public SampleDao sampleDao() {
		return new SampleDao();
	}
}
