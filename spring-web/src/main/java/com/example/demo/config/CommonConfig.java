package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @Configuration
 * 	- 수동으로 객체를 등록시킬 때 사용되는 어노테이션이다.
 *  - @Bean 어노테이션을 이용해서 수동으로 등록시킬 객체를 생성하는 메소드를 작성한다.
 *    XML의 <bean /> 태그 역할을 대신한다. [ 내가 만든 클래스가 아니라 가져와서 쓰는 클래스일 때 ]
 */
@Configuration
public class CommonConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
			.setMatchingStrategy(MatchingStrategies.STRICT); // 매칭 전략 = 이름과 타입이 모두 같을 때
		return modelMapper;
	}
}
