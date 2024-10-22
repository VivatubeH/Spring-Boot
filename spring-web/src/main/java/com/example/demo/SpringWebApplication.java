package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication
 *  	- 스프링부트 애플리케이션의 핵심 어노테이션이다.
 *  	- 스프링부트 애플리케이션의 메인 클래스에 반드시 부착하는 어노테이션이다.
 *      - 아래의 3가지 어노테이션 기능을 모두 포함하는 어노테이션이다.
 *      
 * @SpringBootConfiguration
 * 		- 스프링 부트의 자동설정 외에 추가적인 설정정보를 감지하는 기능을 활성화시키는
 *      어노테이션이다.
 * @EnableAutoConfiguration
 * 		- 스프링 부트의 자동 설정 기능을 활성화시키는 어노테이션이다.
 * @ComponentScan
 * 		- 스프링 컨테이너에 등록될 준비가 된 클래스를 전부 스캔해서
 *      객체를 생성하고 스프링의 빈으로 등록시킨다. ( 스프링 컨테이너가
 *      관리하는 객체가 된다. )
 *      - 애플리케이션의 메인클래스가 위치한 패키지 및 모든 하위 패키지에서
 *      등록될 준비가 된 클래스를 전부 스캔한다.
 *      - 대상
 *      @Component, @Controller, @RestController
 *      @ControllerAdvice, @RestControllerAdvice,
 *      @Service, @Repository
 *      @Configuration
 * 
 */
@SpringBootApplication
public class SpringWebApplication {

	public static void main(String[] args) {
		/*
		 * SpringApplication.run()
		 *  - 스프링 부트 애플리케이션의 메인 클래스의 메인 메소드에서 실행된다.
		 *  - 스프링 부트 애플리케이션을 실행시킨다.
		 *    * 설정정보를 로딩한다.
		 *    * 스프링 컨테이너를 생성하고, 초기화한다.
		 *    * 자동 설정을 적용시킨다.
		 *    * 내장된 웹서버(톰캣)을 실행시킨다.
		 *    * 스프링 컨테이너에 빈을 등록하고, 조립(의존성주입)한다.
		 *    * 애플리케이션을 시작한다.
		 */
		SpringApplication.run(SpringWebApplication.class, args);
	}

}
